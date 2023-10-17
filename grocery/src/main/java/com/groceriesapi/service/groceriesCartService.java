package com.groceriesapi.service;

import com.groceriesapi.dataAccess.DTO.CartDto;
import com.groceriesapi.dataAccess.Entity.Cart;
import com.groceriesapi.dataAccess.Entity.Order;
import com.groceriesapi.model.UserItemResponse;

import java.util.List;

public interface groceriesCartService {
    public Cart AddCart(CartDto cart);
    public List<Cart> ViewCart();
    public List<UserItemResponse> getItemDetails();
    public List<Order> order(List<Order> order);
}
