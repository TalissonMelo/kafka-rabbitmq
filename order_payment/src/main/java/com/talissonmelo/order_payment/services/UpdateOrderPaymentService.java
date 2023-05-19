package com.talissonmelo.order_payment.services;

import org.springframework.stereotype.Service;

import com.talissonmelo.order_payment.entities.OrderPayment;
import com.talissonmelo.order_payment.entities.request.UpdateOrderPaymentRequest;
import com.talissonmelo.order_payment.entities.response.OrderPaymentResponse;
import com.talissonmelo.order_payment.repositories.OrderPaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOrderPaymentService {

	private final OrderPaymentRepository repository;

	public OrderPaymentResponse execute(String orderPaymentId, UpdateOrderPaymentRequest request) {

		OrderPayment orderPayment = repository.findById(orderPaymentId).orElseThrow(
				() -> new IllegalArgumentException("A Order Payment with ID " + orderPaymentId + " does not exist"));

		orderPayment.update(request.price(), request.observation());

		return toOrderPaymentResponse(repository.save(orderPayment));
	}

	private OrderPaymentResponse toOrderPaymentResponse(OrderPayment orderPayment) {
		return new OrderPaymentResponse(orderPayment.getId(), orderPayment.getIdOrder(), orderPayment.getTitle(),
				orderPayment.getDescription(), orderPayment.getStatus(), orderPayment.getPrice(),
				orderPayment.getObservation());
	}
}
