package com.example.shop.cartItem.services;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.cartItem.dtos.CartItemResponseDTO;
import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.repositories.CartItemRepository;
import com.example.shop.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<CartItemResponseDTO> findByCart(UUID cartId) {
        List<CartItem> items = cartItemRepository.findByCartId(cartId);
        return items.stream()
                .map(CartItemResponseDTO::new)
                .toList();
    }

    public CartItem findById(UUID id){
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("/{id}"));
    }

    public void remove(UUID cartItemId){
        if(!cartItemRepository.existsById(cartItemId)){ throw new RuntimeException("CartItem não encontrado"); }
        cartItemRepository.deleteById(cartItemId);
    }

    public void removeOne(UUID cartItemId){
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if(item.getQuantity() > 1){
            item.setQuantity(item.getQuantity() - 1);
            cartItemRepository.save(item);
        } else {
            cartItemRepository.delete(item);
        }
    }

}

