package com.intcomex.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDto {

    private Long id;

    private String productName;

    private Integer quantityPerUnit;

    private BigDecimal unitPrice;

    private Integer unitsInStock;

    private Integer unitsOnOrder;

    private int reorderLevel;

    private Long supplierId;

    private CategoryResponseDto category;
}
