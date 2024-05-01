package com.productservice.productservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc; // Used to make Dummy/Mock API calls to Controller layer

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProductsReturnEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        // We are performing Mock API call and the type is Get, and we are telling our expectation also. If our expectation is correct then TC will pass
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void getAllProductsReturnValidList() throws Exception {

        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        genericProductDtoList.add(new GenericProductDto());
        genericProductDtoList.add(new GenericProductDto());
        genericProductDtoList.add(new GenericProductDto());


        when(productService.getAllProducts()).thenReturn(genericProductDtoList);

        // We are performing Mock API call and the type is Get, and we are telling our expectation also. If our expectation is correct then TC will pass
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtoList)));
    }

    @Test
    void createProduct() throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("MacBook");
        genericProductDto.setPrice(10000L);
        genericProductDto.setDescription("Fastest PC");
        genericProductDto.setCategory("Laptop");

        GenericProductDto outputGenericProductDto = new GenericProductDto();
        outputGenericProductDto.setTitle(genericProductDto.getTitle());
        outputGenericProductDto.setPrice(genericProductDto.getPrice());
        outputGenericProductDto.setDescription(genericProductDto.getDescription());
        outputGenericProductDto.setCategory(genericProductDto.getCategory());
        outputGenericProductDto.setId(1000L);

        when(productService.createProduct(genericProductDto)).thenReturn(outputGenericProductDto);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(genericProductDto)))
                .andExpect(content().string(objectMapper.writeValueAsString(outputGenericProductDto)))
                .andExpect(status().is(200));
    }

}
