package com.productservice.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass //We are telling Hibernate, not to create any table of this parent class, and pass on the attributes of this class to its child class
public class BaseModel { // BaseModel will contain the common attributes of Product and Category class
    @Id  // We are marking "id" as primary key
    private Long id;
}
