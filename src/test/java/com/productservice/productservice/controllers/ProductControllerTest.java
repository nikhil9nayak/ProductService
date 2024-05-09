package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakestoreClient.FakeStoreClientAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productServiceMock;
//
//    @Captor
//    private ArgumentCaptor<Long> argumentCaptor;
//
//    // Start: Dummy Testing (Without Mocking)
//    @Autowired
//    FakeStoreClientAdapter fakeStoreClientAdapter;
//
//    @Test
//    @DisplayName("Dummy Testing") // giving custom display name for this TC
//    void testOnePlusOneIsTwoOrNot(){
//        assertEquals(2, 1+1, "1+1 should be 2"); // Checks the expected value (2) vs the output of the expression, If assert is TRUE, TC succeeds, else fails
//        assertTrue(1==1); // checks a positive scenario for boolean values
//        assertFalse(1!=1); // checks a negative scenario for boolean values
//        assertNull(null); // checks a whether it is NUll
//        assertNotNull(null); // checks a whether it is not NUll
//    }
//
//    @Test
//    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
//        assertThrows(ProductNotFoundException.class, () -> fakeStoreClientAdapter.getProductById(1000L));
//        assertNull(fakeStoreClientAdapter.getProductById(1L));
//    }
//    // End: Dummy Testing
//
//
//    @Test
//    void testGetProductByIdMocking() throws ProductNotFoundException {
//        when(productServiceMock.getProductById(100L)).thenReturn(null); // This is Mocking. We're Telling Mockito, return "null" whenever getProductById is called with argument "100L"
//        GenericProductDto output = productController.getProductById(100L); // We actually calling getProductById() with "100L", and it won't call the Db instead It will return "null" as we hardcoded "null" for argument "100L"
//        assertEquals(null, output); // at last, we assert that the returned output matches the expected value.
//    }
//
//
//    @Test
//    void testGetProductByIdMockingException() throws ProductNotFoundException {
//        when(productServiceMock.getProductById(1L)).thenThrow(ProductNotFoundException.class);
//        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(1L));
//    }
//
//    @Test
//    void testProductControllerCallsProductServiceWithSameProductIdAsInput() throws ProductNotFoundException {
//        // This is the TC to check if productController is passing the same productId to the productService as the input
//        when(productServiceMock.getProductById(100L)).thenReturn(new GenericProductDto());
//        productController.getProductById(100L);
//        verify(productServiceMock).getProductById(argumentCaptor.capture());
//        assertEquals(100L, argumentCaptor.getValue());
//    }
}
