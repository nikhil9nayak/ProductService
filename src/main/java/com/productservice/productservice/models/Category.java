package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity// this @ indicating that, "Category" table will be created inside the DB and instances of this class will be mapped to this table
public class Category extends BaseModel{
   private String name;
}
