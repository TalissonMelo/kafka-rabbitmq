package com.talissonmelo.order.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.order.entities.request.OrderRequest;
import com.talissonmelo.order.entities.response.OrderResponse;
import com.talissonmelo.order.kafka.KafkaProducerMessage;
import com.talissonmelo.order.service.CreateOrderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Order")
public class CreateOrderController {

	private final CreateOrderService service;
	private final KafkaProducerMessage kafkaProducerMessage;

	@PostMapping("/v1/orders")
	public ResponseEntity<OrderResponse> execute(@Valid @RequestBody OrderRequest request) {
		var response = service.execute(request);
		log.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Order Post information: {}", response);
		kafkaProducerMessage.sendMessage(response);
		return ResponseEntity.status(201).body(response);
	}

}
