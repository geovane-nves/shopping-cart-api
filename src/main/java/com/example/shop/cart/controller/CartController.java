package com.example.shop.cart.controller;

import com.example.shop.cart.dtos.AddProductRequest;
import com.example.shop.cart.dtos.CartResponseDTO;
import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.services.CartService;
import com.example.shop.cartItem.dtos.CartItemResponseDTO;
import com.example.shop.cartItem.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public List<CartResponseDTO> getOrders() {
        return service.findAll()
                .stream()
                .map(CartResponseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponseDTO> findById(@PathVariable UUID id){
        CartResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}/add-product")
    public ResponseEntity<CartItemResponseDTO> addProduct(@PathVariable UUID id, @RequestBody AddProductRequest request) {
        CartItemResponseDTO response = service.addProduct(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
