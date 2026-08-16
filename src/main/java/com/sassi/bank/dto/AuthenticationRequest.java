package com.sassi.bank.dto;

import lombok.Data;

/**
 * @author Hatem SASSI
 */
@Data
public class AuthenticationRequest {

  private String email;
  private String password;
}
