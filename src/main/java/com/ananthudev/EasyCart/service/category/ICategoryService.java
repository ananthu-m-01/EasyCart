package com.ananthudev.EasyCart.service.category;

import com.ananthudev.EasyCart.dto.category.CategoryCreateDTO;
import com.ananthudev.EasyCart.dto.category.CategoryResponseDTO;
import com.ananthudev.EasyCart.dto.category.CategoryUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategoryById(Long id);
    CategoryResponseDTO addCategory(CategoryCreateDTO categoryCreateDTO);
    CategoryResponseDTO updateCategory(Long id,CategoryUpdateDTO categoryUpdateDTO);
    ResponseEntity<String> deleteCategoryById(Long id);
}
