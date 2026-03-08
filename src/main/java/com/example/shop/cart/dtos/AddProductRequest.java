package com.example.shop.cart.dtos;

import java.util.UUID;

public record AddProductRequest(
        UUID productId,
        Integer quantity
) {}