package com.intcomex.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intcomex.api.models.dtos.CreateCategoryRequestDto;
import com.intcomex.api.models.dtos.CreateProductRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@WebAppConfiguration
class ProductControllerTest {

    public final static String BASE_URL = "/api/products";
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUP(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void findAll() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)
                        .queryParam("enablePagination","false")
                        .accept(MediaType.APPLICATION_JSON_VALUE))

                .andReturn();

        assertEquals(200,mockMvcResult.getResponse().getStatus());
    }

    @Test
    void findById() {
    }

    @Test
    void findAllByCategoryId() {
    }

    @Test
    void save() throws Exception {

        CreateProductRequestDto createProductRequestDto = builCreateProductRequestDto();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(createProductRequestDto)))
                .andReturn();
        assertEquals(201,result.getResponse().getStatus());
    }

    @Test
    void saveWithException() throws Exception {

        CreateProductRequestDto createProductRequestDto = CreateProductRequestDto.builder().build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(createProductRequestDto)))
                .andReturn();
        assertEquals(400,result.getResponse().getStatus());

    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    private CreateProductRequestDto builCreateProductRequestDto(){

        return CreateProductRequestDto.builder()
                .productName("PRODUCT NAME TEST UNIT")
                .quantityPerUnit(3)
                .unitPrice(BigDecimal.valueOf(111.556))
                .unitsInStock(3)
                .unitsInStock(4)
                .unitsOnOrder(5)
                .reorderLevel(8)
                .discontinued(43)
                .supplierId(6L)
                .categoryId(4L)
                .build();

    }


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);

    }
}