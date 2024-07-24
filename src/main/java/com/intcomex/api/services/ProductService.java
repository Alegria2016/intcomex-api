package com.intcomex.api.services;

import com.intcomex.api.models.dtos.CreateProductRequestDto;
import com.intcomex.api.models.dtos.ProductResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {

    ProductResponseDto findById(Long id);

    Page<ProductResponseDto> findAll(Pageable pageable);

    List<ProductResponseDto> findAllByCategoryId(Long categoryId);

    ProductResponseDto save(CreateProductRequestDto request);

    ProductResponseDto update(Long id, CreateProductRequestDto request);

    void deleteById(Long id);
}
