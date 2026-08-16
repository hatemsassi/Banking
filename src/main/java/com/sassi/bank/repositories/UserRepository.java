package com.sassi.bank.repositories;

import com.sassi.bank.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Hatem SASSI
 * @since 13.09.22
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
}
