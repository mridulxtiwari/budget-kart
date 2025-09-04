package com.microservices.budget_cart.order_service.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private List<ItemRequest> itemList;
}
