package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity// this @ indicating that, "Category" table will be created inside the DB and instances of this class will be mapped to this table
public class Category extends BaseModel{
   @Column(nullable = false, unique = true)
   private String name;

   @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
   // If we don't use mappedBy then spring will create a mapping table, To tell spring that manyToOne is already used inside product class so dont use another relation here
   private List<Product> products; // In Product class if the category is ManyToOne then in Category class products will be vise-versa i.e. OneToMany
}
