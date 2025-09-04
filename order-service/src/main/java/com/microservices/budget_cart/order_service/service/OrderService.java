package com.microservices.budget_cart.order_service.service;

import com.microservices.budget_cart.order_service.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public void placeOrder(OrderRequest orderRequest);
}
