package com.example.Wood.services;

import com.example.Wood.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getALlProducts();
    List<ProductDto> getALlShops();

    List<ProductDto> getALlServicess();

    ProductDto getProductById(Long id);
}
