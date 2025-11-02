package com.ananthudev.EasyCart.service.category;

import com.ananthudev.EasyCart.dto.category.CategoryCreateDTO;
import com.ananthudev.EasyCart.dto.category.CategoryResponseDTO;
import com.ananthudev.EasyCart.dto.category.CategoryUpdateDTO;
import com.ananthudev.EasyCart.exceptions.category.CategoryNotFoundException;
import com.ananthudev.EasyCart.model.Category;
import com.ananthudev.EasyCart.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;
    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::toCategoryResponseDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {

        return categoryRepository.findById(id)
                .map(Category::toCategoryResponseDTO)
                .orElseThrow(()-> new CategoryNotFoundException("category not found with id : "+id));
    }

    @Override
    public CategoryResponseDTO addCategory(CategoryCreateDTO categoryCreateDTO) {
        Category category = Category.builder()
                .name(categoryCreateDTO.getName())
                .description(categoryCreateDTO.getDescription())
                .build();
        Category savedCategory = categoryRepository.save(category);
        return savedCategory.toCategoryResponseDTO();
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryUpdateDTO categoryUpdateDTO) {
        boolean exists = categoryRepository.findAll().stream().anyMatch(c -> c.getId().equals(id));
        if(! exists){
            throw new CategoryNotFoundException("category not found with id "+id);
        }

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("category not found with id : "+id));

        Category updatedCategory = Category.builder()
                .id(existingCategory.getId())
                .name(categoryUpdateDTO.getName())
                .description(categoryUpdateDTO.getDescription())
                .build();
        Category savedCategory = categoryRepository.save(updatedCategory);
        return savedCategory.toCategoryResponseDTO();
    }

    @Override
    public ResponseEntity<String> deleteCategoryById(Long id) {
        boolean exists = categoryRepository.findAll().stream().anyMatch(c -> c.getId().equals(id));
        if(!exists){
            throw new CategoryNotFoundException("category not found with id : "+id);
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.ok("category deleted");
    }
}
