package com.sassi.bank.services.impl;

import com.sassi.bank.dto.ContactDto;
import com.sassi.bank.models.Contact;
import com.sassi.bank.repositories.ContactRepository;
import com.sassi.bank.services.ContactService;
import com.sassi.bank.validators.ObjectsValidator;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Hatem SASSI
 */

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactRepository repository;
  private final ObjectsValidator<ContactDto> validator;

  @Override
  public Integer save(ContactDto dto) {
    validator.validate(dto);
    Contact contact = ContactDto.toEntity(dto);
    return repository.save(contact).getId();
  }

  @Override
  public List<ContactDto> findAll() {
    return repository.findAll()
        .stream()
        .map(ContactDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public ContactDto findById(Integer id) {
    return repository.findById(id)
        .map(ContactDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("No contact was found with the ID :" + id));
  }

  @Override
  public void delete(Integer id) {
    // todo check delete
    repository.deleteById(id);
  }

  @Override
  public List<ContactDto> findAllByUserId(Integer userId) {
    return repository.findAllByUserId(userId)
        .stream()
        .map(ContactDto::fromEntity)
        .collect(Collectors.toList());
  }
}
