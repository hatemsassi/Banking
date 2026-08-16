package com.sassi.bank.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Hatem SASSI
 * @since 15.09.22
 */

@RequiredArgsConstructor
@Getter
public class OperationNonPermittedException extends RuntimeException {

  private final String errorMsg;

  private final String operationId;

  private final String source;

  private final String dependency;

}
