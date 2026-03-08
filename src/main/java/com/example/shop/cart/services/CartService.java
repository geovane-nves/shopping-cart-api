package com.example.shop.cart.services;

import com.example.shop.cart.dtos.AddProductRequest;
import com.example.shop.cart.dtos.CartResponseDTO;
import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.cartItem.dtos.CartItemResponseDTO;
import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.repositories.CartItemRepository;
import com.example.shop.exceptions.ResourceNotFoundException;
import com.example.shop.product.entities.Product;
import com.example.shop.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public CartResponseDTO findById(UUID id){
        return cartRepository.findById(id)
                .map(CartResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public CartItemResponseDTO addProduct(UUID cartId, AddProductRequest request) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        Product product = productRepository.findById(request.productId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        CartItem item = cartItemRepository.findByCartIdAndProductId(cartId, product.getId()).orElseGet(() -> {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setPriceAtMoment(product.getPrice());
            newItem.setQuantity(0);
            return newItem;
        });
        int newQuantity = item.getQuantity() + request.quantity();
        if (newQuantity > product.getStockQuantity()) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity greater than stock");}

        item.setQuantity(newQuantity);
        return new CartItemResponseDTO(cartItemRepository.save(item));
    }
}