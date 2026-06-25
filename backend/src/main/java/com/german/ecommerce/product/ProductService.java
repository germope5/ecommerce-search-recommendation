package com.german.ecommerce.product;

import org.springframework.stereotype.Service;

import java.util.List;
import com.german.ecommerce.product.dto.CreateProductRequest;
import com.german.ecommerce.product.dto.ProductResponse;
import com.german.ecommerce.product.dto.UpdateProductRequest;
import com.german.ecommerce.exception.ProductNotFoundException;
import com.german.ecommerce.exception.DuplicateSkuException;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse create(CreateProductRequest request) {

        if (repository.existsBySku(request.getSku())) {
            throw new DuplicateSkuException("SKU already exists");
        }

        Product product = new Product();
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        Product saved = repository.save(product);

        return toResponse(saved);
    }

    public List<ProductResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

    }

    public ProductResponse findById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));
        return toResponse(product);
    }

    private ProductResponse toResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setSku(product.getSku());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());

        return response;
    }

    // Método para Actualizar productos
    public ProductResponse update (
            Long id,
            UpdateProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        Product updated = repository.save(product);

        return toResponse(updated);
    }

    //Método para Eliminar un producto
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Product not found");
        }

        repository.deleteById(id);
    }
}