package com.example.shop.config;

import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null,"Geovane", "geonevesrodrigues@gmail.com", "pasword123", Instant.parse("2019-06-20T19:53:07Z"));
        User user2 = new User(null,"SeiLa", "seila@gmail.com", "pasword123", Instant.parse("2019-06-20T19:53:07Z"));

        userRepository.saveAll(Arrays.asList(user1,user2));

        System.out.println("TEST CONFIG EXECUTOU");
    }
}
