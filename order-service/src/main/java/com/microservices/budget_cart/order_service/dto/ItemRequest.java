package com.microservices.budget_cart.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
