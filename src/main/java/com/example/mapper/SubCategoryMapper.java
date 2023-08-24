package com.example.mapper;

import com.example.dto.SubCategoryDto;
import com.example.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    SubCategoryMapper subCategory = Mappers.getMapper(SubCategoryMapper.class);

    SubCategoryDto mapDto(SubCategory subCategory);

    SubCategory mapEntity(SubCategoryDto SubCategoryDto);

    List<SubCategoryDto> mapDto(List<SubCategory> subCategory);

    List<SubCategory> mapEntity(List<SubCategoryDto> SubCategoryDto);
}
