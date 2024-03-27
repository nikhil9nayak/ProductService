package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice // This allows us to centralize exception handling logic across multiple controllers. Instead of handling all the exceptions inside controller class, we will handle here
public class ProductControllerAdvices { // control will come to this class when any Controller throws any exception. We can gather all the exception in this class

    @ExceptionHandler(ProductNotFoundException.class)  // the job of this method is, when ever ProductNotFoundException occur inside any controller, this method will auto trigger
    @ResponseStatus(HttpStatus.NOT_FOUND) //Setting the HttpStatus
    @ResponseBody() // If we use this @, We will see whatever body we are created(httStatus and Message). If we are not using this then we will see the whole body in the postman response
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDto.setMessage(productNotFoundException.getMessage());
        // return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND); // instead of this line we can use @ResponseStatus and @ResponseBody
        return exceptionDto;
    }
}
