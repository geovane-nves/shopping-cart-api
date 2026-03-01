package com.example.shop.cart.services;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
}
