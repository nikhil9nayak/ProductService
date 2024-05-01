package com.productservice.productservice.thirdPartyClients.fakestoreClient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component // If it in not service, repository, controller class then at that class we use @Component
public class FakeStoreClientAdapter {

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreUrl;

    @Value("${fakestore.api.paths.products}")
    private String pathForProducts;
    private String specificProductUrl;
    private String genericProductUrl;

    public FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.url}") String fakeStoreUrl,
                                  @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.genericProductUrl = fakeStoreUrl + pathForProducts;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        // Integrate the FakeStore API
        // Spring's RestTemplate help us to consume/use external APIs, here we are using this to use fakeStore external API
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id); // we are mapping JSON value of above URL to FakeStoreProductDto obj, and in 2nd param we are mentioning the type of obj we want in the response
        // Exception Handling
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            // If obj is null then throw exception
            throw new ProductNotFoundException("Product with Id : "+id+" doesn't exists.");
        }
        // Convert FakeStoreProductDto to GenericProductDto before return
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =                         //here we are using array of FakeStoreProductDto instead of list because java doesn't support
                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class); //FakeStoreProductDto[].class it means we need response array of FakeStoreProductDto obj
        List<GenericProductDto> result = new ArrayList<>();
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //there is no direct delete() like getForEntity. below 3 linea are substitute of that. We got these 3 lines from inside the internal getForEntity()
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProductById(GenericProductDto genericProductDto, Long id) {
        // To Be Implemented
        return null;
    }
}
