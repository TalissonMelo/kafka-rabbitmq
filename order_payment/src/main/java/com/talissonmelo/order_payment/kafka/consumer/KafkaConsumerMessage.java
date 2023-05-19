package com.talissonmelo.order_payment.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.talissonmelo.order_payment.entities.request.OrderRequest;
import com.talissonmelo.order_payment.services.CreateOrderPaymentService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumerMessage {

	private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
	private final CreateOrderPaymentService service;

	@KafkaListener(topics = "order-post-topic", groupId = "store-posts-group")
	public void listening(OrderRequest request) {

		LOG.info("ORDER POST - Received Post information: {}", request);
		service.excute(request);
	}

}
