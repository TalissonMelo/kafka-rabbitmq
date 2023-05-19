package com.talissonmelo.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
