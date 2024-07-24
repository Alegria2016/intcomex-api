package com.intcomex.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponseDto {

    private Long id;

    private String categoryName;

    private String description;

    private String picture;
}
