package com.microservices.budget_cart.order_service.service;

import com.microservices.budget_cart.order_service.dto.InventoryResponse;
import com.microservices.budget_cart.order_service.dto.ItemRequest;
import com.microservices.budget_cart.order_service.dto.OrderRequest;
import com.microservices.budget_cart.order_service.entity.Item;
import com.microservices.budget_cart.order_service.entity.Order;
import com.microservices.budget_cart.order_service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class OrderSeviceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WebClient webClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        List<Item> itemList=orderRequest.getItemList().stream().map(this::mapItemDtoToItem).toList();
        Order order =Order.builder()
                .orderId(UUID.randomUUID().toString())
                .itemList(itemList)
                .build();

        List<String>skuCodes=orderRequest.getItemList().stream().map(ItemRequest::getSkuCode).toList();
        InventoryResponse[] inventoryResponses=webClient.get()
                        .uri("http://localhost:8081",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                        .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                        .block();

        boolean isAllInStock= Arrays.stream(inventoryResponses).allMatch(InventoryResponse::getIsInStock);
        if(isAllInStock){
            orderRepository.save(order);
        }else{
            throw  new IllegalArgumentException("Products are out of stock. Please try later.");
        }

        log.info("Order Number : {} placed successfully",order.getOrderId());
    }

    private Item mapItemDtoToItem(ItemRequest itemRequest) {
        return Item.builder()
                .skuCode(itemRequest.getSkuCode())
                .price(itemRequest.getPrice())
                .quantity(itemRequest.getQuantity())
                .build();
    }
}
