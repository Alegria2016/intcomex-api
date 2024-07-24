package com.intcomex.api.models.dtos;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCategoryRequestDto {

    private String categoryName;

    private String description;

    private String picture;
}
