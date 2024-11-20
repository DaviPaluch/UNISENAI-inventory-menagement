package com.paluch.inventory.modules.product;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "product")
@Data
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull(message = "O nome do produto não pode ser nulo")
  private String name;

  @NotNull(message = "A quantidade de estoque não pode ser nula")
  private Integer stockQuantity;

  @NotNull(message = "O fornecedor não pode ser nulo")
  private String supplier;

  @NotNull(message = "A data de validade não pode ser nula")
  private LocalDateTime expiryDate;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
