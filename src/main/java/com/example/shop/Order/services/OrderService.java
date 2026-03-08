package com.example.shop.Order.services;

import com.example.shop.Order.dtos.OrderResponseDTO;
import com.example.shop.Order.entities.Order;
import com.example.shop.Order.repositories.OrderRepository;
import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.product.entities.Product;
import com.example.shop.product.repositories.ProductRepository;
import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public OrderResponseDTO createOrder(UUID userId) {

        User user = userRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUserId_Id(userId).orElseThrow();

        Order order = new Order(user, cart);

        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();

            if (product.getStockQuantity() < item.getQuantity()) {throw new RuntimeException("Insufficient stock");}
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
        }

        Order savedOrder = orderRepository.save(order);
        cart.clear();
        cartRepository.save(cart);

        return new OrderResponseDTO(
                savedOrder.getId(),
                savedOrder.getUserId().getId(),
                savedOrder.getCartId().getId(),
                savedOrder.getCreatedAt(),
                savedOrder.getStatus(),
                savedOrder.getTotalAmount()
        );
    }

    public List<OrderResponseDTO> getOrdersByUser(UUID userId) {
        List<Order> orders = orderRepository.findAllByUserId_Id(userId);

        return orders.stream()
                .map(order -> new OrderResponseDTO(
                        order.getId(),
                        order.getUserId().getId(),
                        order.getCartId().getId(),
                        order.getCreatedAt(),
                        order.getStatus(),
                        order.getTotalAmount()
                ))
                .toList();
    }
}
