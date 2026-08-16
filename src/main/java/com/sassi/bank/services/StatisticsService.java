package com.sassi.bank.services;

import com.sassi.bank.dto.TransactionSumDetails;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Hatem SASSI
 */
public interface StatisticsService {

  List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);

  BigDecimal getAccountBalance(Integer userId);

  BigDecimal highestTransfer(Integer userId);

  BigDecimal highestDeposit(Integer userId);

}
