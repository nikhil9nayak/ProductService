package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // this @ indicating that, "Product" table will be created inside the DB and instances of this class will be mapped to this table
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    // Category is not a primitive attribute, It's a relation.
    @ManyToOne(optional = false) // We are specifying the Cardinality between Product and Category is M:1. Hibernate add a foreign key column in the Product table that references the primary key of the Category table. the foreign key name will be "category_id"
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private Price price;
}

/*

Cardinality between Product and Category is M : 1

   1   L->R    1   (1 product can have 1 category)
Product    Category
   M   L<-R    1   (1 category can have many product)

*/
