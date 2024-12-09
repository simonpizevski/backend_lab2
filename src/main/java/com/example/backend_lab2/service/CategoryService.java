package com.example.backend_lab2.service;

import com.example.backend_lab2.dto.CategoryDTO;
import com.example.backend_lab2.entity.Category;
import com.example.backend_lab2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public List<CategoryDTO> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO createCategory(CategoryDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Category with this name already exists.");
        }

        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setSymbol(dto.getSymbol());
        Category saved = repository.save(category);
        return convertToDTO(saved);
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setSymbol(category.getSymbol());
        return dto;
    }
}
