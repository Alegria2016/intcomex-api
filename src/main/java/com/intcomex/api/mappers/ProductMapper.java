package com.intcomex.api.mappers;

import com.intcomex.api.models.dtos.ProductResponseDto;
import com.intcomex.api.models.entities.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductResponseDto toProductResponse(Product product);

}
