package com.example.shop.users.services;

import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(UUID id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
