package com.groceriesapi.repository;

import com.groceriesapi.dataAccess.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
