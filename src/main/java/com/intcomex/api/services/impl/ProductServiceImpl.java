package com.intcomex.api.services.impl;

import com.intcomex.api.exceptions.CategoryNotFoundException;
import com.intcomex.api.exceptions.ProductNotFoundException;
import com.intcomex.api.exceptions.SupplierNotFoundException;
import com.intcomex.api.mappers.ProductMapper;
import com.intcomex.api.models.dtos.CreateProductRequestDto;
import com.intcomex.api.models.dtos.ProductResponseDto;
import com.intcomex.api.models.entities.Product;
import com.intcomex.api.models.entities.Supplier;
import com.intcomex.api.repositories.CategoryRepository;
import com.intcomex.api.repositories.ProductRepository;
import com.intcomex.api.repositories.SupplierRepository;
import com.intcomex.api.services.ProductService;
import com.intcomex.api.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements ProductService {


    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }



    @Override
    public Page<ProductResponseDto> findAll(Pageable pageable) {

        int startIndex =(int) pageable.getOffset();

        List<Product> products = productRepository.findAll();

        int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());

        List<ProductResponseDto> pageContent = products.subList(startIndex,endIndex) .stream()
                .map(productMapper::toProductResponse)
                .toList();

        return new PageImpl<>(pageContent, pageable,products.size());


    }

    @Override
    public List<ProductResponseDto> findAllByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(productRepository::findAllByCategory)
                .map(products ->products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponseDto save(CreateProductRequestDto request) {
        System.out.println("================== CATEGORY ID"+ request.getCategoryId());
        return categoryRepository.findById(request.getCategoryId())
                .map(category -> {
                    Product product = Product.builder()
                            .productName(request.getProductName())
                            .quantityPerUnit(request.getQuantityPerUnit())
                            .unitPrice(request.getUnitPrice())
                            .unitsInStock(request.getUnitsInStock())
                            .unitsOnOrder(request.getUnitsOnOrder())
                            .reorderLevel(request.getReorderLevel())
                            .discontinued(0)
                            .category(category)
                            .build();

                    return productRepository.save(product);

                }).map(productMapper::toProductResponse).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponseDto update(Long id, CreateProductRequestDto request) {
        return productRepository.findById(id)
                .map(product -> categoryRepository
                        .findById(request.getCategoryId())
                        .map(category -> {
                            product.setProductName(request.getProductName());
                            product.setQuantityPerUnit(request.getQuantityPerUnit());
                            product.setUnitPrice(request.getUnitPrice());
                            product.setUnitsInStock(request.getUnitsInStock());
                            product.setUnitsOnOrder(request.getUnitsOnOrder());
                            product.setReorderLevel(request.getReorderLevel());
                            product.setDiscontinued(request.getDiscontinued());
                            product.setCategory(category);
                            product.setSupplierId(request.getSupplierId());
                            return productRepository.save(product);
                        })
                        .orElseThrow(CategoryNotFoundException::new)
                )
                .map(productMapper::toProductResponse).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {

        if(productRepository.findById(id).isEmpty()){
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);

    }
}
