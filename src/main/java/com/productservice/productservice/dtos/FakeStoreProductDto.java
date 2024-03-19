package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    //DTO -> Data Transfer Objects
    //we create DTO for transferring required data, and we transfer data of both objects together by aggregating them.
    private Long id;
    private String title;
    private Long price;
    private String category;
    private String description;
    private String image;
}
