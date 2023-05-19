package com.talissonmelo.order.service;

import org.springframework.stereotype.Service;

import com.talissonmelo.order.entities.Order;
import com.talissonmelo.order.entities.request.OrderRequest;
import com.talissonmelo.order.entities.response.OrderResponse;
import com.talissonmelo.order.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateOrderService {

	private final OrderRepository repository;

	public OrderResponse execute(OrderRequest request) {
		Order order = Order.createOrder(request.title(), request.description());
		return toOrderResponse(repository.save(order));

	}

	private OrderResponse toOrderResponse(Order order) {

		return new OrderResponse(order.getId(), order.getTitle(), order.getDescription(), order.getStatus());
	}
}
