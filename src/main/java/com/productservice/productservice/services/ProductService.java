package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService { //we are making this as an interface, so it won't violate DIP(Dependency Inversion Principle) https://www.youtube.com/watch?v=S9awxA1wNNY

    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id);
}
