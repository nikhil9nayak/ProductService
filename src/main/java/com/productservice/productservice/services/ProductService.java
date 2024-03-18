package com.productservice.productservice.services;

import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService { //we are making this as an interface, so it won't violate DIP(Dependency Inversion Principle) https://www.youtube.com/watch?v=S9awxA1wNNY

    String getProductById(Long id);
    void getAllProducts();
    void deleteProductById();
    void createProduct();
    void updateProductById();
}
