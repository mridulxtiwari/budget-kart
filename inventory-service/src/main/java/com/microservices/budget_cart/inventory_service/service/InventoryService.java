package com.microservices.budget_cart.inventory_service.service;

import com.microservices.budget_cart.inventory_service.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
