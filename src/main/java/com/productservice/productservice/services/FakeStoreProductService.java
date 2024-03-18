package com.productservice.productservice.services;

import org.springframework.stereotype.Service;

@Service("fakeStoreProductService") //in parameter, we specify the bean name. When Spring create bean/obj of this class it should name that bean as same as parameter
public class FakeStoreProductService implements ProductService{
    @Override
    public String getProductById(Long id) {
        // Integrate the FakeStore API
        return "Hey Champ...";
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
