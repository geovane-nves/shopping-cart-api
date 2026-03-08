package com.example.shop.cart.dtos;

import com.example.shop.cart.entities.Cart;
import com.example.shop.users.dtos.UserDTO;

import java.math.BigDecimal;
import java.util.UUID;

public record CartResponseDTO (
     UUID id,
     BigDecimal total,
     UserDTO user
){
    public CartResponseDTO(Cart cart){
        this(
                cart.getId(),
                cart.getTotal(),
                new UserDTO(cart.getUserId())
        );
    }
}