package com.example.shop.cartItem.controller;


import com.example.shop.cart.dtos.CartResponseDTO;
import com.example.shop.cartItem.dtos.CartItemResponseDTO;
import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/items")
public class CartItemController {

    @Autowired
    private CartItemService service;

    @GetMapping("/cart/{cartId}")
    public List<CartItemResponseDTO> getItems(@PathVariable UUID cartId){
        return service.findByCart(cartId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemResponseDTO> findById(@PathVariable UUID id){
        CartItem item = service.findById(id);
        return ResponseEntity.ok(new CartItemResponseDTO(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/remove-one")
    public ResponseEntity<Void> removeOne(@PathVariable UUID id){
        service.removeOne(id);
        return ResponseEntity.noContent().build();
    }
}
