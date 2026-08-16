package com.sassi.bank.repositories;

import com.sassi.bank.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hatem SASSI
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
