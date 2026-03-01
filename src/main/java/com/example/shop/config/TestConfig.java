package com.example.shop.config;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.cartItem.entities.CartItem;
import com.example.shop.cartItem.repositories.CartItemRepository;
import com.example.shop.product.entities.Product;
import com.example.shop.product.repositories.ProductRepository;
import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Geovane", "geonevesrodrigues@gmail.com",
                "password123", null, null, Instant.now());

        User user2 = new User(null, "SeiLa", "seila@gmail.com",
                "password123", null, null, Instant.now());

        userRepository.saveAll(Arrays.asList(user1, user2));


// 🔹 Criando cart já ligado ao user (Cart é o dono)
        Cart cart1 = new Cart(null, user1, Instant.now());

// importante manter os dois lados sincronizados
        user1.setCart(cart1);

        cartRepository.save(cart1);


// 🔹 Produto
        Product p1 = new Product(null, "cartzinho", null,
                new BigDecimal("599.00"), 4, Instant.now());

        productRepository.save(p1);


// 🔹 Item do carrinho
        CartItem i1 = new CartItem(null, p1, 2, null, cart1);
        cartItemRepository.save(i1);



        System.out.println("TEST CONFIG EXECUTOU");
    }
}
