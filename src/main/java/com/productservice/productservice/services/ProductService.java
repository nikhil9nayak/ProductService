package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService { //we are making this as an interface, so it won't violate DIP(Dependency Inversion Principle) https://www.youtube.com/watch?v=S9awxA1wNNY

    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id);
}
