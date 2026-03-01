package com.example.shop.cart.controller;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        List<Cart> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
