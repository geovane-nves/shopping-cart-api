package com.example.shop.Order.repositories;

import com.example.shop.Order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    Order findByUserId_Id(UUID userId);

    List<Order> findAllByUserId_Id(UUID userId);

}
