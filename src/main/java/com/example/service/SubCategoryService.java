package com.example.service;

import com.example.dto.SubCategoryDto;
import com.example.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryDto> getAllCategories();

    SubCategoryDto getCategory(Integer id);

    void addCategory(SubCategoryDto category);

    void deleteCategory(Integer id);
}
