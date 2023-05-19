package com.talissonmelo.order.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.talissonmelo.order.entities.response.OrderResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaProducerMessage {

	private final KafkaTemplate<String, OrderResponse> kafkaTemplate;
	private final String KAFKA_TOPIC = "order-post-topic";

	public void sendMessage(OrderResponse object) {
		kafkaTemplate.send(KAFKA_TOPIC, object);
	}

}
