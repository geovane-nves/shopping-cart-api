package com.example.shop.product.entities;

import com.example.shop.cartItem.entities.CartItem;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @UuidGenerator
    @Column(name = "product_Id", nullable = false, unique = true)
    private UUID id;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CartItem> cartItems;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer strockQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdAt;

    public Product() {
    }

    public Product(UUID id, String name, String description, BigDecimal price, Integer strockQuantity, Instant creatAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.strockQuantity = strockQuantity;
        this.createdAt = creatAt;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public Integer getStrockQuantity() {return strockQuantity;}

    public void setStrockQuantity(Integer strockQuantity) {this.strockQuantity = strockQuantity;}

    public Instant getCreatedAt() {return createdAt;}

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
