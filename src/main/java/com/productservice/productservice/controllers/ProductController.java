package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //to tell spring this class contains REST Apis
@RequestMapping("/products")
public class ProductController { //this controller will contain all the API related to product

    private ProductService productService;

    // Constructor Injection
    ProductController(ProductService productService){ //@Qualifier used to specify the bean name when we have two or more beans configured for the same type ProductService
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException { //used to extract the "id" value from the URL
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){ //from Request Body pick the JSON obj and map with GenericProductDto obj
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/id")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto genericProductDto, @PathVariable("id") Long id){
        return productService.updateProductById(genericProductDto, id);
    }

    // Way-1 to Handle Exceptions
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){ // the job of this method is, when ever ProductNotFoundException occur inside this controller package this method will auto trigger
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        //Setting the HttpStatus
//        ResponseEntity responseEntity = new ResponseEntity(exceptionDto, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}

/*
3 ways of Dependency Injection:
-------------------------------
1- Constructor Injection: (this is preferable over Field Injection as this is more readable)
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