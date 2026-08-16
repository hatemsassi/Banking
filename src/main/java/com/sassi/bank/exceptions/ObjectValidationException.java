package com.sassi.bank.exceptions;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Hatem SASSI
 * @since 15.09.22
 */

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {

  @Getter
  private final Set<String> violations;

  @Getter
  private final String violationSource;

}
