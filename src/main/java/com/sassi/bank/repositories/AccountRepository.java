package com.sassi.bank.repositories;

import com.sassi.bank.models.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hatem SASSI
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

  Optional<Account> findByIban(String iban);

  Optional<Account> findByUserId(Integer id);
}
