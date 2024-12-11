package com.example.backend_lab2.service;

import com.example.backend_lab2.dto.CategoryDTO;
import com.example.backend_lab2.entity.Category;
import com.example.backend_lab2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryDTO dto = new CategoryDTO();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setSymbol(category.getSymbol());
                    dto.setDescription(category.getDescription());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public CategoryDTO findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    CategoryDTO dto = new CategoryDTO();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setSymbol(category.getSymbol());
                    dto.setDescription(category.getDescription());
                    return dto;
                }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.findByName(categoryDTO.getName()).isPresent()) {
            throw new RuntimeException("Category name already exists");
        }
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setSymbol(categoryDTO.getSymbol());
        category.setDescription(categoryDTO.getDescription());
        categoryRepository.save(category);
    }


}
