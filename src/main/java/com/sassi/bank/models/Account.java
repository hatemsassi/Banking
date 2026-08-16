package com.sassi.bank.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Hatem SASSI
 * @since 12.09.22
 */

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account extends AbstractEntity {

  private String iban;

  @OneToOne
  @JoinColumn(name = "id_user")
  private User user;
}
