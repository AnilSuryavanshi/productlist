package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.service.CategoryService;
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
        name = "Category Rest API CRUD Operations",
        description = "CREATE, READ, UPDATE & DELETE operations for Category Rest API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @Operation(
            summary = "Create Categories",
            description = "Rest API to Create Categories"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN)")
    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Fetch all Categories",
            description = "Rest API to fetch all Categories"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @Operation(
            summary = "Fetch Category by category id",
            description = "Rest API to fetch Category by category id"
    )
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @Operation(
            summary = "Delete Category by category id",
            description = "Rest API to Delete Category by category id"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN)")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}

