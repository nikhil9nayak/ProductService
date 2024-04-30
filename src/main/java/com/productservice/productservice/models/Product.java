package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // this @ indicating that, "Product" table will be created inside the DB and instances of this class will be mapped to this table
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    // Category is not a primitive attribute, It's a relation.
    @ManyToOne(optional = false) // We are specifying the Cardinality between Product and Category is M:1. Hibernate add a foreign key column in the Product table that references the primary key of the Category table. the foreign key name will be "category_id"
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) // If we use cascade, If we delete product then it will delete category and price also (first we create price then category then product)
    private Price price;
    private int inventoryCount;
}

/*

Cardinality between Product and Category is M : 1

   1   L->R    1   (1 product can have 1 category)
Product    Category
   M   L<-R    1   (1 category can have many product)

*/
