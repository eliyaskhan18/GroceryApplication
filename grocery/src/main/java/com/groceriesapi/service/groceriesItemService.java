package com.groceriesapi.service;

import com.groceriesapi.dataAccess.DTO.ItemDto;
import com.groceriesapi.dataAccess.Entity.Inventory;
import com.groceriesapi.dataAccess.Entity.Item;

import java.util.List;

public interface groceriesItemService {
    public List<Inventory> ItemDetails();
    public Item updateItem(ItemDto item);
    public Item DeleteItem(ItemDto item);
    public Inventory AddItem(ItemDto item);

    List<Item> ItemDetailsforuser();
}
