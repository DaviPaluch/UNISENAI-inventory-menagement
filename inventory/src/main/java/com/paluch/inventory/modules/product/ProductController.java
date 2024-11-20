package com.paluch.inventory.modules.product;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductEntity>> getAllProducts() {
    return ResponseEntity.ok(productService.findAll());
  }

  @PostMapping
  public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
    return ResponseEntity.ok(productService.create(product));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductEntity> getProductById(@PathVariable UUID id) {
    return ResponseEntity.ok(productService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductEntity> updateProduct(@PathVariable UUID id, @RequestBody ProductEntity product) {
    return ResponseEntity.ok(productService.update(id, product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
