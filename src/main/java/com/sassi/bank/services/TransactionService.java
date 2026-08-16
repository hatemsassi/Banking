package com.sassi.bank.services;

import com.sassi.bank.dto.TransactionDto;
import java.util.List;

/**
 * @author Hatem SASSI
 */
public interface TransactionService extends AbstractService<TransactionDto> {

  List<TransactionDto> findAllByUserId(Integer userId);
}
