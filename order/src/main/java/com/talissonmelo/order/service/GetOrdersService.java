package com.talissonmelo.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.talissonmelo.order.entities.Order;
import com.talissonmelo.order.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetOrdersService {

	private final OrderRepository repository;

	public Page<Order> execute(Pageable pageable) {
		log.info("LIST ORDERS");
		return repository.findAll(pageable);
	}
}
