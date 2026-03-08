package com.example.shop.users.dtos;

import com.example.shop.users.entities.User;
import com.example.shop.users.enums.UserType;
import java.util.UUID;

public record UserDTO(
        UUID id,
        String name,
        String email,
        UserType type
) {
    public UserDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getType()
        );
    }
}