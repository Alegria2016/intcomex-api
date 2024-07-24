package com.intcomex.api.exceptions;

import com.intcomex.api.models.dtos.ErrorResponse;
import com.intcomex.api.utils.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRODUCT_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(ErrorCatalog.PRODUCT_NOT_FOUND.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handleCategoryNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.CATEGORY_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(ErrorCatalog.CATEGORY_NOT_FOUND.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_PRODUCT.getCode())
                .status(HttpStatus.BAD_REQUEST)
                .message(ErrorCatalog.INVALID_PRODUCT.getMessage())
                .detailMessage(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage
                                ).collect(Collectors.toList())
                )
                .timeStamp(LocalDate.now())
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInternalServerError(Exception exception){

        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .detailMessage(Collections.singletonList(exception.getMessage()))
                .timeStamp(LocalDate.now())
                .build();
    }
}
