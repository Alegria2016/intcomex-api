package com.intcomex.api.controllers;

import com.intcomex.api.models.dtos.CategoryResponseDto;
import com.intcomex.api.models.dtos.CreateCategoryRequestDto;
import com.intcomex.api.models.dtos.CreateProductRequestDto;
import com.intcomex.api.models.dtos.ProductResponseDto;
import com.intcomex.api.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto findById(@PathVariable Long id){
        return categoryService.findById(id);
    }



    @PostMapping
    public ResponseEntity<CategoryResponseDto> save(@Valid @RequestBody CreateCategoryRequestDto request){

        try{
            CategoryResponseDto response = categoryService.save(request);
            return ResponseEntity.created(URI.create("api/category" +response.getId())).body(response);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }

    }
}
