package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product Rest API CRUD Operations",
        description = "CREATE, READ, UPDATE & DELETE operations for Product Rest API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @Operation(
            summary = "Create Products",
            description = "Rest API to Create Products"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER)")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createProduct =  productService.createProduct(productDTO);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Fetch all Products",
            description = "Rest API to fetch all Products"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }

    @Operation(
            summary = "Fetch Product by product id",
            description = "Rest API to fetch Product by product id"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @Operation(
            summary = "Update Products",
            description = "Rest API to Update Products"
    )
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @Operation(
            summary = "Delete Product by product id",
            description = "Rest API to Delete Product by product id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER)")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
