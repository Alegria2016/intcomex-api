package com.intcomex.api.controllers;

import com.intcomex.api.models.dtos.CreateProductRequestDto;
import com.intcomex.api.models.dtos.ProductResponseDto;
import com.intcomex.api.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public Page<ProductResponseDto> findAll(@PageableDefault Pageable pageable){
        return productService.findAll(pageable);
    }


    @GetMapping("/{id}")
    public ProductResponseDto findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/category/{id}")
    public List<ProductResponseDto> findAllByCategoryId(@PathVariable Long id){
        return productService.findAllByCategoryId(id);
    }


    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@Valid @RequestBody CreateProductRequestDto request){
        ProductResponseDto response = productService.save(request);
        return ResponseEntity.created(URI.create("api/products" +response.getId())).body(response);
    }


    @PutMapping("{id}")
    public ProductResponseDto update(
            @PathVariable Long id,
            @Valid @RequestBody CreateProductRequestDto request ){
        return productService.update(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
       productService.deleteById(id);
    }

}
