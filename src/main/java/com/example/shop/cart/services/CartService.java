package com.example.shop.cart.services;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository repository;
    private final UserRepository userRepository;

    public CartService(CartRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


}
