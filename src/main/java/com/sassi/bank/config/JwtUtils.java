package com.sassi.bank.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

  private final SecretKey signingKey;

  public JwtUtils(@Value("${jwt.secret-key}") String jwtSigningKey) {
    this.signingKey = Keys.hmacShaKeyFor(jwtSigningKey.getBytes(StandardCharsets.UTF_8));
  }

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public boolean hasClaim(String token, String claimName) {
    final Claims claims = extractAllClaims(token);
    return claims.get(claimName) != null;
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser()
        .verifyWith(signingKey)
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userDetails);
  }

  public String generateToken(UserDetails userDetails, Map<String, Object> claims) {
    return createToken(claims, userDetails);
  }

  private String createToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
        .claims(claims)
        .subject(userDetails.getUsername())
        .claim("authorities", userDetails.getAuthorities())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(200)))
        .signWith(signingKey)
        .compact();
  }

  public Boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

}
