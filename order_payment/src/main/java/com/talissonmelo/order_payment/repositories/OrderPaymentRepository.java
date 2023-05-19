package com.talissonmelo.order_payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.order_payment.entities.OrderPayment;

public interface OrderPaymentRepository extends JpaRepository<OrderPayment, String> {

}
