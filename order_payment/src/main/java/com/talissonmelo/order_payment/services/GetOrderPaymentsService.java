package com.talissonmelo.order_payment.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.talissonmelo.order_payment.entities.OrderPayment;
import com.talissonmelo.order_payment.repositories.OrderPaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetOrderPaymentsService {

	private final OrderPaymentRepository repository;

	public Page<OrderPayment> execute(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
