package com.talissonmelo.order_payment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.order_payment.entities.response.OrderPaymentResponse;
import com.talissonmelo.order_payment.kafka.producer.KafkaProducerMessage;
import com.talissonmelo.order_payment.services.UpdateOrderPaymentStatusService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "OrderPayment")
public class UpdateOrderPaymentStatusController {

	private final UpdateOrderPaymentStatusService service;
	private final KafkaProducerMessage kafkaProducerMessage;

	@PutMapping("/v1/orders-payments/{orderPaymentId}/done")
	public ResponseEntity<OrderPaymentResponse> toDone(@PathVariable String orderPaymentId) {
		var response = service.toDone(orderPaymentId);
		log.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Order Payment PUT STATUS DONE information: {}", response);
		kafkaProducerMessage.sendMessage(response);
		return ResponseEntity.status(200).body(response);
	}

	@PutMapping("/v1/orders-payments/{orderPaymentId}/canceled")
	public ResponseEntity<OrderPaymentResponse> toCanceled(@PathVariable String orderPaymentId) {
		var response = service.toCanceled(orderPaymentId);
		log.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Order Payment PUT STATUS CANCELED information: {}", response);
		kafkaProducerMessage.sendMessage(response);
		return ResponseEntity.status(200).body(response);
	}

}
