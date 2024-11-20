package com.paluch.inventory.modules.stockMovement;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.paluch.inventory.modules.enums.MovementType;
import com.paluch.inventory.modules.product.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "stock_movement")
@Data
public class StockMovementEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private ProductEntity product;

  @NotNull(message = "A quantidade não pode ser nula")
  private Integer quantity;

  @NotNull(message = "O tipo de movimentação deve ser 'ENTRY' ou 'EXIT'")
  @Enumerated(EnumType.STRING)
  private MovementType type;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
