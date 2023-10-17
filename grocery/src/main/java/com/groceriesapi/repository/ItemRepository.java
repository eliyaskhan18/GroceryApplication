package com.groceriesapi.repository;

import com.groceriesapi.dataAccess.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item , String> {

}
