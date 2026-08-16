package com.sassi.bank.controllers;

import com.sassi.bank.dto.AuthenticationRequest;
import com.sassi.bank.dto.AuthenticationResponse;
import com.sassi.bank.dto.UserDto;
import com.sassi.bank.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hatem SASSI
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "authentication")
public class AuthenticationController {

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody UserDto user) {

    return ResponseEntity.ok(userService.register(user));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(userService.authenticate(request));
  }

}
