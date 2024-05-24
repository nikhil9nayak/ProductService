package com.productservice.productservice.dtos;

import com.productservice.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {//this class is giving one more layer of abstraction to FakeStoreProductDto
    private Long id;
    private String title;
    private Long price;
    private String category;
    private String description;
    private String image;
    private int inventoryCount;
}
