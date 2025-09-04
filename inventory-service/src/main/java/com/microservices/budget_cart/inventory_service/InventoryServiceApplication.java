package com.microservices.budget_cart.inventory_service;

import com.microservices.budget_cart.inventory_service.entity.Inventory;
import com.microservices.budget_cart.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = Inventory.builder()
                    .skuCode("Iphone_13")
                    .quantity(100)
                    .build();
            Inventory inventory2 = Inventory.builder()
                    .skuCode("Iphone_15")
                    .quantity(100)
                    .build();
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }
}
