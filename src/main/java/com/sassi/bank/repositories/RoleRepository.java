package com.sassi.bank.repositories;

import com.sassi.bank.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hatem SASSI
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByName(String roleName);
}
