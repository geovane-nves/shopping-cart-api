package com.example.shop.cartItem.entities;

import com.example.shop.cart.entities.Cart;
import com.example.shop.product.entities.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cartItem")
public class CartItem {

    @Id
    @UuidGenerator
    @Column(name = "cartItem_id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Integer quantity;

    private Double priceAtMoment;

    public CartItem() {
    }

    public CartItem(UUID id, Product product, Integer quantity, Double priceAtMoment, Cart cart) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.priceAtMoment = priceAtMoment;
        this.cart = cart;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getPriceAtMoment() {return priceAtMoment;}

    public void setPriceAtMoment(double priceAtMoment) {this.priceAtMoment = priceAtMoment;}

    public Cart getCart() {return cart;}

    public void setCart(Cart cart) {this.cart = cart;}

    public Double subTotal(){
        return quantity * priceAtMoment;
    }
}
