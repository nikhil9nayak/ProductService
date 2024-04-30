package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreClient.FakeStoreClientAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

    @Inject
    private ProductController productController;

    @Inject
    FakeStoreClientAdapter fakeStoreClientAdapter;


    @Test
    @DisplayName("Dummy Testing") // giving custom display name for this TC
    void testOnePlusOneIsTwoOrNot(){
//        assertEquals(2, 1+1, "1+1 should be 2"); // Checks the expected value (2) vs the output of the expression, If assert is TRUE, TC succeeds, else fails
//        assertTrue(1==1); // checks a positive scenario for boolean values
//        assertFalse(1!=1); // checks a negative scenario for boolean values
//        assertNull(null); // checks a whether it is NUll
//        assertNotNull(null); // checks a whether it is not NUll
    }

    @Test
    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class, () -> fakeStoreClientAdapter.getProductById(1000L));

        //assertNull(fakeStoreClientAdapter.getProductById(1L));
    }
}
