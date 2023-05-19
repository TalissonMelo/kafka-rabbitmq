package com.talissonmelo.order_payment.services;

import org.springframework.stereotype.Service;

import com.talissonmelo.order_payment.entities.OrderPayment;
import com.talissonmelo.order_payment.entities.response.OrderPaymentResponse;
import com.talissonmelo.order_payment.repositories.OrderPaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOrderPaymentStatusService {

	private final OrderPaymentRepository repository;
	
	private OrderPayment findById(String orderPaymentId) {
		return repository.findById(orderPaymentId).orElseThrow(
				() -> new IllegalArgumentException("A Order Payment with ID " + orderPaymentId + " does not exist"));
	}
	
	public OrderPaymentResponse toDone(String orderPaymentId) {
		OrderPayment payment = findById(orderPaymentId);
		payment.toDone();
		return toOrderPaymentResponse(repository.save(payment));
	}
	
	public OrderPaymentResponse toCanceled(String orderPaymentId) {
		OrderPayment payment = findById(orderPaymentId);
		payment.toCanceled();
		return toOrderPaymentResponse(repository.save(payment));
	}
	
	private OrderPaymentResponse toOrderPaymentResponse(OrderPayment orderPayment) {
		return new OrderPaymentResponse(orderPayment.getId(), orderPayment.getIdOrder(), orderPayment.getTitle(),
				orderPayment.getDescription(), orderPayment.getStatus(), orderPayment.getPrice(),
				orderPayment.getObservation());
	}
}
