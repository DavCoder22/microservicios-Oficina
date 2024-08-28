package com.microservice.inventory.service;

import com.microservice.inventory.entities.Inventory;

import java.util.List;

public interface IInventoryService {

    List<Inventory> findAllInventories();

    Inventory findById(Long id);

    void save(Inventory inventory);

    void deleteById(Long id);

    List<Inventory> findByProductId(Long productId);
}
