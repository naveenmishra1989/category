package com.example.service.impl;

import com.example.dto.SubCategoryDto;
import com.example.mapper.SubCategoryMapper;
import com.example.repository.SubCategoryRepository;
import com.example.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.mapper.SubCategoryMapper.subCategory;

@Repository
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository repository;
    private final SubCategoryMapper subMapper;

    @Override
    public List<SubCategoryDto> getAllCategories() {
        return subMapper.mapDto(repository.findAll());
    }

    @Override
    public SubCategoryDto getCategory(Integer id) {
        return repository.findById(id)
                .map(subCategory::mapDto)
                .orElseThrow(() -> new RuntimeException("SubCategory not found :" + id));
    }

    @Override
    public void addCategory(SubCategoryDto subCategory) {
        repository.save(subMapper.mapEntity(subCategory));
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.findById(id).ifPresentOrElse(repository::delete, () -> {
            throw new RuntimeException("SubCategory not found:" + id);
        });
    }
}
