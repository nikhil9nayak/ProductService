package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.security.JWTObject;
import com.productservice.productservice.security.TokenValidator;
import com.productservice.productservice.thirdPartyClients.fakestoreClient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("fakeStoreProductService") //in parameter, we specify the bean name. When Spring create bean/obj of this class it should name that bean as same as parameter
public class FakeStoreProductService implements ProductService{

    FakeStoreClientAdapter fakeStoreAdapter;

    private TokenValidator tokenValidator;

    public FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter,
                                   TokenValidator tokenValidator) {
        this.fakeStoreAdapter = fakeStoreAdapter;
        this.tokenValidator = tokenValidator;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){ // this is just converting from FakeStoreProductDto to GenericProductDto, giving one more layer of abstraction to FakeStoreProductDto
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException {

        //Validate the JWT token
        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);

        if (jwtObjectOptional.isEmpty()){
            //Invalid token, Reject the request
            return null;
        }
        JWTObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUserId();

        // We are calling fakeStoreAdapter class
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) {
        // To Be Implemented
        return null;
    }
}
