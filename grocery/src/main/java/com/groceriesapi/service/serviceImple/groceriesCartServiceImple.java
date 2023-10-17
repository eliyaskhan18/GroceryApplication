package com.groceriesapi.service.serviceImple;

import com.groceriesapi.dataAccess.DTO.CartDto;
import com.groceriesapi.dataAccess.Entity.*;
import com.groceriesapi.model.UserItemResponse;
import com.groceriesapi.repository.CartRepository;
import com.groceriesapi.repository.InventoryRepository;
import com.groceriesapi.repository.OderRepository;
import com.groceriesapi.service.groceriesCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class groceriesCartServiceImple implements groceriesCartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private OderRepository oderRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Cart AddCart(CartDto cart) {
        Cart cart1 = setCardAmount(cart);
        cartRepository.save(cart1);
        return cart1;
    }

    private Cart setCardAmount(CartDto dto) {
        Cart cart = new Cart();
        cart.setItem_name(dto.getItem_name());
        cart.setQty(dto.getQty());
        cart.setPrice(dto.getPrice());
        cart.setAmount(dto.getPrice() * dto.getQty());
        return cart;
    }

    @Override
    public List<Cart> ViewCart() {
        List<Cart> carts = cartRepository.findAll();
        return carts;
    }

    @Override
    public List<UserItemResponse> getItemDetails() {
        return null;
    }

    @Override
    public List<Order> order(List<Order> order) {
        for (Order ord :order
             ) {
            boolean b = updateInventory(ord);
            if (b){
                orderRepository.save(ord);
            }
        }
        return order;
    }

    private boolean updateInventory(Order ord) {
        Optional<Inventory> inventory = inventoryRepository.findById(ord.getItem_code());
        if(inventory.isPresent()){

            int order_qty = inventory.get().getOrdered_qty() + ord.getQty();
            int balance_qty = inventory.get().getTotal_qty() - order_qty;
            inventory.get().setBalance_qty(balance_qty);
            inventory.get().setOrdered_qty(order_qty);
            inventoryRepository.save(inventory.get());
            return true;
        }
        return false;

    }


}
