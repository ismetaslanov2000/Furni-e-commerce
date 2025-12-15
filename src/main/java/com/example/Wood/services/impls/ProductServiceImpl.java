package com.example.Wood.services.impls;

import com.example.Wood.dtos.ProductDto;
import com.example.Wood.models.Product;
import com.example.Wood.repositories.ProductRepository;
import com.example.Wood.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> getALlProducts() {
        List<ProductDto> productDtos = productRepository.findAll().stream().limit(3).
                map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());

        return productDtos;
    }

    @Override
    public List<ProductDto> getALlShops() {
        List<ProductDto> productDtos = productRepository.findAll().stream().limit(4).
                map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());

        return productDtos;
    }


    @Override
    public List<ProductDto> getALlServicess() {
        List<ProductDto> productDtos = productRepository.findAll().stream().limit(3).
                map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());

        return productDtos;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product= productRepository.findById(id).orElseThrow();
        return modelMapper.map(product,ProductDto.class);
    }
}
