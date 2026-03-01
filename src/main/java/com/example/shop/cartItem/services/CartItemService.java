package com.example.shop.cartItem.services;

import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> findAll(){
        return cartItemRepository.findAll();
    }

    public CartItem findById(UUID id){
        Optional<CartItem> obj = cartItemRepository.findById(id);
        return obj.get();
    }
}
