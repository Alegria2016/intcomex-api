package com.intcomex.api.mappers;

import com.intcomex.api.models.dtos.CategoryResponseDto;
import com.intcomex.api.models.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDto toCategoryResponse(Category category);
}
