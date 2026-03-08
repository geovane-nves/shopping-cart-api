package com.example.shop.users.services;

import com.example.shop.cart.entities.Cart;
import com.example.shop.cart.repositories.CartRepository;
import com.example.shop.exceptions.DataBaseException;
import com.example.shop.exceptions.ResourceNotFoundException;
import com.example.shop.users.dtos.CreateUserRequest;
import com.example.shop.users.dtos.UserDTO;
import com.example.shop.users.entities.User;
import com.example.shop.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CartRepository cartRepository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO findById(UUID id) {
        return repository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }
    
    public User insert(User obj){
        return repository.save(obj);
    }

    public UserDTO createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());

        user = repository.save(user);

        Cart cart = new Cart();
        cart.setUserId(user);
        cartRepository.save(cart);
        return new UserDTO(user);
    }

    public void delete(UUID id){
        try { repository.deleteById(id); }
        catch (EmptyResultDataAccessException e) { throw new ResourceNotFoundException(id); }
        catch (DataIntegrityViolationException e) { throw new DataBaseException(e.getMessage()); }
    }
}
