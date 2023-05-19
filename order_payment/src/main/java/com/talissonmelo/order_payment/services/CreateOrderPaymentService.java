package com.talissonmelo.order_payment.services;

import org.springframework.stereotype.Service;

import com.talissonmelo.order_payment.entities.OrderPayment;
import com.talissonmelo.order_payment.entities.request.OrderRequest;
import com.talissonmelo.order_payment.repositories.OrderPaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateOrderPaymentService {

	private final OrderPaymentRepository repository;
	
	public void excute(OrderRequest request) {
		OrderPayment orderPayment = OrderPayment.createOrder(request.title(), request.description(), request.id());
		repository.save(orderPayment);
	}
}
