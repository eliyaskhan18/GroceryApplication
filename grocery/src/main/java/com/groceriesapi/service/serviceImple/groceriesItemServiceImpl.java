package com.groceriesapi.service.serviceImple;

import com.groceriesapi.dataAccess.DTO.ItemDto;
import com.groceriesapi.dataAccess.Entity.Item;
import com.groceriesapi.dataAccess.Entity.Inventory;
import com.groceriesapi.repository.InventoryRepository;
import com.groceriesapi.repository.ItemRepository;
import com.groceriesapi.service.groceriesItemService;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class groceriesItemServiceImpl implements groceriesItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    @RolesAllowed({"ROLE_ADMIN"})
    public List<Inventory> ItemDetails() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories;
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN"})
    public Item updateItem(ItemDto item) {
        boolean b = setInventoryTotalQty(item);
        Item entity = null;
        if(b){
            entity = setItem(item);
            Item Updateditem = itemRepository.saveAndFlush(entity);
        }

        return entity;
    }

    private boolean setInventoryTotalQty(ItemDto item) {
        Optional<Inventory> inventory = inventoryRepository.findById(item.getItem_Code());
        if(inventory.isPresent()){
            inventory.get().setTotal_qty(inventory.get().getTotal_qty()+item.getQty());
            inventory.get().setBalance_qty(inventory.get().getBalance_qty()+item.getQty());
            inventoryRepository.saveAndFlush(inventory.get());
            return true;
        }
        return false;
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN"})
    public Item DeleteItem(ItemDto item) {
        DeleteInventory(item);
        Item entity = setItem(item);
        itemRepository.delete(entity);
        return null;
    }

    private void DeleteInventory(ItemDto item) {
        inventoryRepository.deleteById(item.getItem_Code());
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN"})
    public Inventory AddItem(ItemDto item) {
        Item itemEntity = setItem(item);
        itemRepository.saveAndFlush(itemEntity);
        Inventory inventory = setInvertory(item);
        inventoryRepository.save(inventory);
        return inventory;
    }

    @Override
    public List<Item> ItemDetailsforuser() {
        List<Item> items = itemRepository.findAll();
        return items;
    }


    private Item setItem(ItemDto item) {

        Item entity = new Item();
        entity.setItem_code(item.getItem_Code());
        entity.setName(item.getName());
        entity.setPrice(item.getPrice());
        entity.setDescription(item.getDescription());
        return entity;
    }

    private Inventory setInvertory(ItemDto item ){
        Inventory inventory = new Inventory();
        inventory.setItem_code(item.getItem_Code());
        inventory.setItem_name(item.getName());
        inventory.setBalance_qty(item.getQty());
        inventory.setTotal_qty(item.getQty());

       return inventory;
    }
}
