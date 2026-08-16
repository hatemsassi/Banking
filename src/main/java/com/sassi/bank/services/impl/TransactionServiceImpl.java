package com.sassi.bank.services.impl;

import com.sassi.bank.dto.TransactionDto;
import com.sassi.bank.models.Transaction;
import com.sassi.bank.models.TransactionType;
import com.sassi.bank.repositories.TransactionRepository;
import com.sassi.bank.services.TransactionService;
import com.sassi.bank.validators.ObjectsValidator;
import java.math.BigDecimal;
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
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository repository;
  private final ObjectsValidator<TransactionDto> validator;

  @Override
  public Integer save(TransactionDto dto) {
    validator.validate(dto);
    Transaction transaction = TransactionDto.toEntity(dto);
    BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
    BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
    transaction.setAmount(amount);
    return repository.save(transaction).getId();
  }

  @Override
  public List<TransactionDto> findAll() {
    return repository.findAll()
        .stream()
        .map(TransactionDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public TransactionDto findById(Integer id) {
    return repository.findById(id)
        .map(TransactionDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("No transaction was found with the ID: " + id));
  }

  @Override
  public void delete(Integer id) {
    // todo check delete
    repository.deleteById(id);
  }

  private int getTransactionMultiplier(TransactionType type) {
    return TransactionType.TRANSFERT == type ? -1 : 1;
  }

  @Override
  public List<TransactionDto> findAllByUserId(Integer userId) {
    return repository.findAllByUserId(userId)
        .stream()
        .map(TransactionDto::fromEntity)
        .collect(Collectors.toList());
  }
}
