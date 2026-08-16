package com.sassi.bank.validators;

import com.sassi.bank.exceptions.ObjectValidationException;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

/**
 * @author Hatem SASSI
 * @since 15.09.22
 */

@Component
public class ObjectsValidator<T> {


  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  public void validate(T objectToValidate) {
    Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
    if (!violations.isEmpty()) {
      Set<String> errorMessages = violations.stream()
          .map(ConstraintViolation::getMessage)
          .collect(Collectors.toSet());
      throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
    }
  }

}
