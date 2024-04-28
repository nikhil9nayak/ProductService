package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseModel{
    /*
          1             M    (one order can have multiple products)
        Order--------Product
          M             1    (one product can be ordered in multiple orders)

          M:M Cardinality
    */
    @ManyToMany
    private List<Product> products; // a single order can have multiple products
}
