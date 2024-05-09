package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator { //This is the method to be used for validating a JWT token. This class will be used when any APIs from ProdServ want to use JWT authorization.

    /**
       Remember: We will use RestTemplate, whenever we are trying to call one MicroService to another MicroService
       Here we are calling ProductService to UserService
     */
    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }


    /**
     This below method should call the UserSevice to validate the token
     If the token is valid then return the corresponding object else return empty
     */
    public Optional<JWTObject> validateToken(String token){ // This method will be like, If token is valid give me a valid JWTObject else null
        RestTemplate restTemplate = restTemplateBuilder.build();

        //Make an HTTP call to UserService to call the validateToken method
        return Optional.empty();
    }
}
