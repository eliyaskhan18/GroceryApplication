package com.groceriesapi.repository;

import com.groceriesapi.dataAccess.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Order, String> {
}
