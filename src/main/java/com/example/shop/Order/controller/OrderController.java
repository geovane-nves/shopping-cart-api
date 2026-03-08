package com.example.shop.Order.controller;

import com.example.shop.Order.dtos.OrderResponseDTO;
import com.example.shop.Order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public OrderResponseDTO createOrder(@PathVariable UUID userId) {
        return orderService.createOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDTO> getOrdersByUser(@PathVariable UUID userId) {
        return orderService.getOrdersByUser(userId);
    }
}
