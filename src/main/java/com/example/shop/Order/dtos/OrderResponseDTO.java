package com.example.shop.Order.dtos;

import com.example.shop.Order.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record OrderResponseDTO(
        UUID orderId,
        UUID userId,
        UUID cartId,
        Instant createdAt,
        OrderStatus status,
        BigDecimal totalAmount
) {}