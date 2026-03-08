package com.example.shop.Order.entities;

import com.example.shop.Order.enums.OrderStatus;
import com.example.shop.cart.entities.Cart;
import com.example.shop.users.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @UuidGenerator
    @Column(name = "order_id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cartId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private BigDecimal totalAmount;

    public Order() {
    }

    public Order(User userId, Cart cartId) {
        this.userId = userId;
        this.cartId = cartId;
        this.createdAt = Instant.now();
        this.status = OrderStatus.CREATED;
        this.totalAmount = cartId.getTotal();
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public User getUserId() {return userId;}

    public void setUserId(User userId) {this.userId = userId;}

    public Cart getCartId() {return cartId;}

    public void setCartId(Cart cartId) {this.cartId = cartId;}

    public Instant getCreatedAt() {return createdAt;}

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}

    public OrderStatus getStatus() {return status;}

    public void setStatus(OrderStatus status) {this.status = status;}

    public BigDecimal getTotalAmount() {return totalAmount;}

    public void setTotalAmount(BigDecimal totalAmount) {this.totalAmount = totalAmount;}
}
