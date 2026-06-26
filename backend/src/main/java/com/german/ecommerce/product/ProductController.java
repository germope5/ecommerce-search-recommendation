package com.german.ecommerce.product;

import com.german.ecommerce.product.dto.CreateProductRequest;
import com.german.ecommerce.product.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.german.ecommerce.product.dto.UpdateProductRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Products", description = "Operaciones CRUD de productos")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

     @Operation(summary = "Crear producto")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto creado"),
        @ApiResponse(responseCode = "400", description = "Validación fallida",
            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
        @ApiResponse(responseCode = "409", description = "SKU duplicado",
            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })

    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody CreateProductRequest request) {

        return service.create(request);
    }

    @Operation(summary = "Obtener producto por ID")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
        content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    @GetMapping
    public List<ProductResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Actualizar producto existente")
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Producto actualizado con éxito"),
    @ApiResponse(responseCode = "400", description = "Validación fallida / ID no coincide",
        content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
        content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
    @ApiResponse(responseCode = "409", description = "Conflicto: SKU duplicado con otro producto",
        content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
})

    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }


    @Operation(summary = "Eliminar producto por ID")
    @ApiResponses({
    @ApiResponse(responseCode = "204", description = "Producto eliminado con éxito"),
    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
        content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}