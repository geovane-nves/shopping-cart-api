package com.example.shop.users.dtos;

public record CreateUserRequest(
        String name,
        String email,
        String password
) {}