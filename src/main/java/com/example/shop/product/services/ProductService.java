package com.example.shop.product.services;

import com.example.shop.exceptions.DataBaseException;
import com.example.shop.exceptions.ResourceNotFoundException;
import com.example.shop.product.entities.Product;
import com.example.shop.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(UUID id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj){
        return obj = repository.save(obj);
    }

    public void delete(UUID id){
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e) {throw new ResourceNotFoundException(id);}
        catch (DataIntegrityViolationException e) {throw new DataBaseException(e.getMessage());}
    }
}
