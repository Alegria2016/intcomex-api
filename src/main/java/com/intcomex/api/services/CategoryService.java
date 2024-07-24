package com.intcomex.api.services;

import com.intcomex.api.models.dtos.CategoryResponseDto;
import com.intcomex.api.models.dtos.CreateCategoryRequestDto;



import java.util.List;

public interface CategoryService {

    CategoryResponseDto findById(Long id);

    List<CategoryResponseDto> findAll();


    CategoryResponseDto save(CreateCategoryRequestDto request);

    CategoryResponseDto update(Long id, CreateCategoryRequestDto request);

    void deleteById(Long id);
}
