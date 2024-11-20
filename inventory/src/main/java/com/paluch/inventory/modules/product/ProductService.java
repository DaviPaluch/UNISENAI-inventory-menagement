package com.paluch.inventory.modules.product;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  // Lista todos os produtos
  public List<ProductEntity> findAll() {
    return productRepository.findAll();
  }

  // Busca um produto pelo ID
  public ProductEntity findById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id));
  }

  // Cria um novo produto
  public ProductEntity create(ProductEntity product) {
    return productRepository.save(product);
  }

  // Atualiza os dados de um produto
  public ProductEntity update(UUID id, ProductEntity updatedProduct) {
    ProductEntity existingProduct = findById(id);
    existingProduct.setName(updatedProduct.getName());
    existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
    existingProduct.setSupplier(updatedProduct.getSupplier());
    existingProduct.setExpiryDate(updatedProduct.getExpiryDate());
    return productRepository.save(existingProduct);
  }

  // Remove um produto pelo ID
  public void delete(UUID id) {
    ProductEntity product = findById(id);
    productRepository.delete(product);
  }
}
