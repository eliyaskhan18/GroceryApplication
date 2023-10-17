package com.groceriesapi.restcontroller;

import com.groceriesapi.dataAccess.DTO.ItemDto;
import com.groceriesapi.dataAccess.Entity.Inventory;
import com.groceriesapi.dataAccess.Entity.Item;
import com.groceriesapi.service.groceriesItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/items")
public class AdminController {
    @Autowired
    private groceriesItemService groceriesItemService;
    @GetMapping(value = "/view", produces = "application/json")
    @Secured("ADMIN")
    public List<Inventory> getItems(){
        List<Inventory> items = groceriesItemService.ItemDetails();
        return items;
    }
    @PostMapping(value = "/add", produces = "application/json")
    @Secured("ADMIN")
    public Inventory getAddItem(@RequestBody ItemDto item){
        log.info("Item to be added {}",item);
        return groceriesItemService.AddItem(item);
    }
    @PutMapping(value = "/update", produces = "application/json")
    @Secured("ADMIN")
    public Item getUpdate(ItemDto item){

        return groceriesItemService.updateItem(item);
    }
    @DeleteMapping(value = "/delete", produces = "application/json")
    @Secured("ADMIN")
    public Item getDelete(ItemDto item){

        return groceriesItemService.DeleteItem(item);
    }
    @GetMapping(value = "/viewItems", produces = "application/json")
    public List<Item> getItemsforUser(){
        List<Item> items = groceriesItemService.ItemDetailsforuser();
        log.info("item details {}", items);
        return items;
    }
}
