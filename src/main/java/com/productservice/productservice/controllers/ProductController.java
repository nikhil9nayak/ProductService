package com.productservice.productservice.controllers;

import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController //to tell spring this class contains REST Apis
@RequestMapping("/products")
public class ProductController { //this controller will contain all the API related to product

    private ProductService productService;

    // Constructor Injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){ //@Qualifier used to specify the bean name when we have two or more beans configured for the same type ProductService
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){ //used to extract the "id" value from the URL
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts(){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }

    public void createProduct(){

    }

    public void updateProductById(){

    }
}

/*
3 ways of Dependency Injection:
-------------------------------
1- Constructor Injection:
    private ProductService productService;
    // Constructor Injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){ //@Qualifier used to specify the bean name when we have two or more beans configured for the same type ProductService
        this.productService = productService;
    }
2- Field Injection (@Autowired):
    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;
3- Setter Injection:
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
 */