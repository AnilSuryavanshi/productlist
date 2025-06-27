package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.mapper.CategoryMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Category" + categoryDTO.getName() + " already exist!");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category" + id +" has been deleted";
    }
}
