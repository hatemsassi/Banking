package com.sassi.bank.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Hatem SASSI
 * @since 12.09.22
 */

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

  @Id
  @GeneratedValue
  private Integer id;

  @CreatedDate
  @Column(
      name = "createdDate",
      nullable = false,
      updatable = false
  )
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "lastModifiedDate")
  private LocalDateTime lastModifiedDate;

}
