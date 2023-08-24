package com.example.mapper;

import com.example.dto.CategoryDto;
import com.example.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    CategoryDto mapDto(Category category);

    Category mapEntity(CategoryDto categoryDto);

    List<CategoryDto> mapDtos(List<Category> category);

    List<Category> mapEntities(List<CategoryDto> categoryDto);
}
