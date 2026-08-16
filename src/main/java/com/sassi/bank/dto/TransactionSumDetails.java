package com.sassi.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Hatem SASSI
 */
public interface TransactionSumDetails {

  LocalDate getTransactionDate();

  BigDecimal getAmount();

}
