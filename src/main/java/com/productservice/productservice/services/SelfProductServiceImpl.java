package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        // Make a DB call and get the products with given Id
        GenericProductDto genericProductDto = new GenericProductDto();
        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString("2819d332-a1fa-4284-8a7e-36a00ccfc82e"));

        Product product = optionalProduct.get();

        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setCategory(product.getCategory().toString());

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) {
        return null;
    }
}
