package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDto;
import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProductById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/addproduct")
    public ProductDto saveProduct(@RequestBody ProductDto productProductDto) {
        return productService.saveProduct(productProductDto);
    }

    @PutMapping("/updateproduct")
    public ProductDto updateProduct(@RequestBody ProductDto productProductDto) {
        return productService.updateProduct(productProductDto);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}