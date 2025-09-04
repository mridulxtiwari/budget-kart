package com.microservices.budget_cart.order_service.controller;

import com.microservices.budget_cart.order_service.dto.OrderRequest;
import com.microservices.budget_cart.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
    }
}
