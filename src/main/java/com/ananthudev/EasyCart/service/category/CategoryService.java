package com.ananthudev.EasyCart.service.category;

import com.ananthudev.EasyCart.dto.category.CategoryCreateDTO;
import com.ananthudev.EasyCart.dto.category.CategoryResponseDTO;
import com.ananthudev.EasyCart.dto.category.CategoryUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryResponseDTO addCategory(CategoryCreateDTO categoryCreateDTO) {
        return null;
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCategoryById(Long id) {
        return null;
    }
}
