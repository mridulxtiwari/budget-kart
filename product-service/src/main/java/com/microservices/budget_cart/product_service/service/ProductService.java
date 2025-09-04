package com.microservices.budget_cart.product_service.service;

import com.microservices.budget_cart.product_service.dto.ProductRequest;
import com.microservices.budget_cart.product_service.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public void addProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();
}
