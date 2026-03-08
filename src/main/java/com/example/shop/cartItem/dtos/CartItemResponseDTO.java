package com.example.shop.cartItem.dtos;

import com.example.shop.cartItem.entities.CartItem;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemResponseDTO(
        UUID id,
        UUID productId,
        String name,
        BigDecimal price,
        Integer quantity,
        BigDecimal subtotal
) {

    public CartItemResponseDTO(CartItem item) {
        this(
                item.getId(),
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getPriceAtMoment(),
                item.getQuantity(),
                item.subTotal()
        );
    }
}