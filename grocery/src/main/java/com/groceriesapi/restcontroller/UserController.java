package com.groceriesapi.restcontroller;

import com.groceriesapi.dataAccess.DTO.CartDto;
import com.groceriesapi.dataAccess.Entity.Cart;
import com.groceriesapi.dataAccess.Entity.Item;
import com.groceriesapi.service.groceriesCartService;
import com.groceriesapi.service.groceriesItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class UserController {
    @Autowired
    private groceriesCartService CartService;
    @Autowired
    private groceriesItemService itemService;
    @PostMapping(name = "/add", produces = "application/json")
    public Cart AddCard(CartDto cart){

        return this.CartService.AddCart(cart);
    }
    @GetMapping(name = "/View", produces = "application/json")
    public List<Cart> CartDetails(){

        return this.CartService.ViewCart();
    }

}
