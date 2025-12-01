package com.example.product.service;

import com.example.product.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto saveProduct(ProductDto productProductDto);
    ProductDto updateProduct(ProductDto productProductDto);
    String deleteProduct(Integer productId);
    ProductDto getProductById(Integer productId);
}
