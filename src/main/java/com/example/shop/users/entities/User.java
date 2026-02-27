package com.example.shop.users.entities;

import com.example.shop.cart.entities.Cart;
import com.example.shop.users.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator
    @Column(name = "user_id", nullable = false, unique = true)
    private UUID id;

    private String name;
    private String email;
    private String password;
    private UserType type = UserType.CLIENT;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant cratedAt;

    public User() {
    }

    public User(UUID id, String name, String email, String password, UserType type, Cart cart, Instant cratedAt ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = UserType.CLIENT;
        this.cart = cart;
        this.cratedAt = Instant.now();
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Instant getCratedAt() {return cratedAt;}

    public void setCratedAt(Instant cratedAt) {this.cratedAt = cratedAt;}

    public Cart getCart() {return cart;}

    public void setCart(Cart cart) {this.cart = cart;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
