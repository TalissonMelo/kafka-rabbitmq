package com.talissonmelo.order_payment.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.order_payment.entities.OrderPayment;
import com.talissonmelo.order_payment.services.GetOrderPaymentsService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "OrderPayment")
public class GetOrderPaymentsController {

	private final GetOrderPaymentsService service;

	@GetMapping("/v1/orders-payments")
	public ResponseEntity<Page<OrderPayment>> execute(@PageableDefault(size = 5) Pageable pageable) {
		var response = service.execute(pageable);
		return ResponseEntity.status(200).body(response);
	}
}
