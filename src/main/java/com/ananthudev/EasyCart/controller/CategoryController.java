package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.category.CategoryCreateDTO;
import com.ananthudev.EasyCart.dto.category.CategoryResponseDTO;
import com.ananthudev.EasyCart.dto.category.CategoryUpdateDTO;
import com.ananthudev.EasyCart.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryResponseDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @GetMapping("/categories/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public CategoryResponseDTO addCategory(@RequestBody CategoryCreateDTO categoryCreateDTO){
        return categoryService.addCategory(categoryCreateDTO);
    }

    @PutMapping("/categories/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable Long id,@RequestBody CategoryUpdateDTO categoryUpdateDTO){
        return categoryService.updateCategory(id,categoryUpdateDTO);
    }

    @DeleteMapping("/categories/id{}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }
}
