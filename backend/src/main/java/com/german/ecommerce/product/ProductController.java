package com.german.ecommerce.product;

import com.german.ecommerce.product.dto.CreateProductRequest;
import com.german.ecommerce.product.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.german.ecommerce.product.dto.UpdateProductRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody CreateProductRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}