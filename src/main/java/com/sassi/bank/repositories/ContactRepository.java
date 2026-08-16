package com.sassi.bank.repositories;

import com.sassi.bank.models.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hatem SASSI
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findAllByUserId(Integer userId);
}
