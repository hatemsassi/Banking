package com.sassi.bank.services.impl;

import com.sassi.bank.dto.AddressDto;
import com.sassi.bank.models.Address;
import com.sassi.bank.repositories.AddressRepository;
import com.sassi.bank.services.AddressService;
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
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;
  private ObjectsValidator<AddressDto> validator;

  @Override
  public Integer save(AddressDto dto) {
    validator.validate(dto);
    Address address = AddressDto.toEntity(dto);
    return repository.save(address).getId();
  }

  @Override
  public List<AddressDto> findAll() {
    return repository.findAll()
        .stream()
        .map(AddressDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public AddressDto findById(Integer id) {
    return repository.findById(id)
        .map(AddressDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
  }

  @Override
  public void delete(Integer id) {
    // todo check delete
    repository.deleteById(id);
  }
}
