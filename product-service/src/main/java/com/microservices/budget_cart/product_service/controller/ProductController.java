package com.microservices.budget_cart.product_service.controller;

import com.microservices.budget_cart.product_service.dto.ProductRequest;
import com.microservices.budget_cart.product_service.dto.ProductResponse;
import com.microservices.budget_cart.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }

    @GetMapping("/product")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
