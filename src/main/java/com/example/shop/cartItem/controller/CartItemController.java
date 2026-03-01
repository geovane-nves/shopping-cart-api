package com.example.shop.cartItem.controller;


import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/items")
public class CartItemController {

    @Autowired
    private CartItemService service;

    @GetMapping
    public ResponseEntity<List<CartItem>> findAll(){
        List<CartItem> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> findById(@PathVariable UUID id){
        CartItem item = service.findById(id);
        return ResponseEntity.ok().body(item);
    }
}
