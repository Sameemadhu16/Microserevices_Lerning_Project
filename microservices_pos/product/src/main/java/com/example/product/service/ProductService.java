package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> getAllProducts() {
        List<Product>productList = productRepo.findAll();
        return modelMapper.map(productList, new TypeToken<List<ProductDto>>(){}.getType());
    }

    public ProductDto saveProduct(ProductDto productProductDto) {
        productRepo.save(modelMapper.map(productProductDto, Product.class));
        return productProductDto;
    }

    public ProductDto updateProduct(ProductDto productProductDto) {
        productRepo.save(modelMapper.map(productProductDto, Product.class));
        return productProductDto;
    }

    public String deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
        return "Product deleted";
    }

    public ProductDto getProductById(Integer productId) {
        Product product = productRepo.getProductById(productId);
        return modelMapper.map(product, ProductDto.class);
    }
}
