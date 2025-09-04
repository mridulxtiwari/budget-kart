package com.microservices.budget_cart.inventory_service.repository;

import com.microservices.budget_cart.inventory_service.dto.InventoryResponse;
import com.microservices.budget_cart.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
