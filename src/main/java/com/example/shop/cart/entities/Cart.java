package com.example.shop.cart.entities;

import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.users.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @UuidGenerator
    @Column(name = "cart_id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdAt;

    public Cart() {
    }

    public Cart(UUID id, User userId, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public User getUserId() {return userId;}

    public void setUserId(User userId) {this.userId = userId;}

    public Instant getCreatedAt() {return createdAt;}

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}


    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem item : cartItems){
          total = total.add(item.subTotal());
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
