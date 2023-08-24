package com.example.service.impl;

import com.example.dto.CategoryDto;
import com.example.entity.Category;
import com.example.mapper.CategoryMapper;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return repository.findAll().stream().map(mapper::mapDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Integer id) {
        return repository.findById(id).map(mapper::mapDto)
                .orElseThrow(() -> new RuntimeException("Category not found id:" + id));

    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = repository.save(mapper.mapEntity(categoryDto));
        return mapper.mapDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {

        return repository.findById(category.getId())
                .map(repository::save)
                .map(mapper::mapDto)
                .orElseThrow(() -> new RuntimeException("Category not found id:" + category.getId()));
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete,
                        () -> {
                            throw new RuntimeException("Category not found id:" + id);
                        });
    }
}
