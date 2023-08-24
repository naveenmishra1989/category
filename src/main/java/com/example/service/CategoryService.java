package com.example.service;

import com.example.dto.CategoryDto;
import com.example.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategory(Integer id);

    CategoryDto addCategory(CategoryDto category);

    CategoryDto updateCategory(CategoryDto category);

    void deleteCategory(Integer id);

}
