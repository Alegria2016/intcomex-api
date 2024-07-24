package com.intcomex.api.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateProductRequestDto {


    @NotEmpty(message = "The field productName cannot be empty or null.")
    private String productName;

    //@NotEmpty(message = "The field quantityPerUnit cannot be empty or null.")
    private Integer quantityPerUnit;

    //@NotEmpty(message = "The field unitPrice cannot be empty or null.")
    private BigDecimal unitPrice;

    private Integer unitsInStock;

    private Integer unitsOnOrder;

    //@NotEmpty(message = "The field reorderLevel cannot be empty or null.")
    private int reorderLevel;

    private int discontinued;

    //@NotEmpty(message = "The field categoryId cannot be empty or null.")
    private Long categoryId;

    //@NotEmpty(message = "The field supplierId cannot be empty or null.")
    private Long supplierId;
}
