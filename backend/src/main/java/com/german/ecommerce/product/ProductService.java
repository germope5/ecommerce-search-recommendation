package com.german.ecommerce.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductService repository;

    public ProductService(ProductService repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        if(repository.existsBySku(product.getSku())) {
            throw new RuntimeException("SKU already exists");
        }

        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findBy(Long id) {
        return repository.findBy(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}