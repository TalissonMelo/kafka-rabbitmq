package com.talissonmelo.order_payment.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.talissonmelo.order_payment.entities.response.OrderPaymentResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaProducerMessage {

	private final KafkaTemplate<String, OrderPaymentResponse> kafkaTemplate;
	private final String KAFKA_TOPIC = "order-payment-post-topic";

	public void sendMessage(OrderPaymentResponse object) {
		kafkaTemplate.send(KAFKA_TOPIC, object);
	}

}
