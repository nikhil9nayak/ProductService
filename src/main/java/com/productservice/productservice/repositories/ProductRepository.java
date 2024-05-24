package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    List<Product> findAll(); // Get all the products from Product table. If we try to run this method, in background it will run this sql query "select * from Product;"

    List<Product> findAllByTitle(String title); // Get all the products with given title. in background, it will run this sql query "select * from Product where title = ... ;"

    List<Product> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Product> findAllByTitleAndDescription(String title, String desc); // select * from Product where title = ".." and description = ".."

    List<Product> findAllByPrice_ValueGreaterThan(Integer x); // select * from product p1_0 left join price p2_0 on p2_0.id=p1_0.price_id where p2_0.value>?

    //List<Product> findAllByPrice_ValueBetween(Integer x, Integer y); // select * from product p1_0 left join price p2_0 on p2_0.id=p1_0.price_id where p2_0.value between x and y

    @Query(value = "select * from product", nativeQuery = true) //If we use @Query and hard coded the query what we want, then It will use the hard coded query over auto generated query when this method called
    List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);

    /*
    NOTE:
     The query will auto generate in background as per the method name we are giving
     for e.g If we want to generate a query for "find all products whose price are greater than xyz" then we have to give the method name as "findAllByPrice_ValueGreaterThan"
     instead of price if we give frice "findAllByFrice_ValueGreaterThan" then It won't work
     Price is not direct attribute for Product table, so we use "Price_Value" inside "findAllByPrice_ValueGreaterThan"
     Title and Description are 2 direct attributes, so we can use them directly like this "findAllByTitleAndDescription"

    */

}
