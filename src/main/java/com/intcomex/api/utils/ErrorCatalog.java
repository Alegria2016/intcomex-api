package com.intcomex.api.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    PRODUCT_NOT_FOUND("ERROR_PRODUCT_001","Product not found."),

    INVALID_PRODUCT("ERROR_PRODUCT_002","Invalid product parameter"),

    CATEGORY_NOT_FOUND("ERROR_CATEGORY_001","Category not found."),

    GENERIC_ERROR("ERROR_GENERIC_001","An unexpected error occurred.");


    private final String code;

    private final String message;


    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }
}
