package com.intcomex.api.services.impl;

import com.intcomex.api.exceptions.CategoryNotFoundException;
import com.intcomex.api.mappers.CategoryMapper;
import com.intcomex.api.models.dtos.CategoryResponseDto;
import com.intcomex.api.models.dtos.CreateCategoryRequestDto;
import com.intcomex.api.models.entities.Category;
import com.intcomex.api.repositories.CategoryRepository;
import com.intcomex.api.services.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryResponseDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toCategoryResponse)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public List<CategoryResponseDto> findAll() {


        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto save(CreateCategoryRequestDto request) {
        Category category = Category.builder()
                .categoryName(request.getCategoryName())
                .description(request.getDescription())
                .picture(request.getPicture())
                .build();

        Category categorySave = categoryRepository.save(category);

        return categoryMapper.toCategoryResponse(categorySave);
    }

    @Override
    public CategoryResponseDto update(Long id, CreateCategoryRequestDto request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
