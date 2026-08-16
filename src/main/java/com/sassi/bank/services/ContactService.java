package com.sassi.bank.services;

import com.sassi.bank.dto.ContactDto;
import java.util.List;

/**
 * @author Hatem SASSI
 */
public interface ContactService extends AbstractService<ContactDto> {

  List<ContactDto> findAllByUserId(Integer userId);
}
