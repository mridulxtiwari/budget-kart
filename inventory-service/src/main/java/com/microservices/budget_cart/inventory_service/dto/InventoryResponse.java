package com.microservices.budget_cart.inventory_service.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
    private String skuCode;
    private Boolean isInStock;
}
