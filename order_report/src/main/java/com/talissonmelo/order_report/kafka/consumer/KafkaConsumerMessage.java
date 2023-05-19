package com.talissonmelo.order_report.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.talissonmelo.order_report.entities.enums.OrderStatus;
import com.talissonmelo.order_report.entities.request.OrderReportRequest;
import com.talissonmelo.order_report.entities.request.UpdateOrderRequest;
import com.talissonmelo.order_report.rabbitmq.AppEventGateway;
import com.talissonmelo.order_report.repositories.OrderReportRespository;
import com.talissonmelo.order_report.services.CreateOrderReportService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumerMessage {

	private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
	private final CreateOrderReportService service;
	private final OrderReportRespository respository;
	private final AppEventGateway appEventGateway;

	@KafkaListener(topics = "order-payment-post-topic", groupId = "order-payment-post-group")
	public Object listening(OrderReportRequest request) {

		LOG.info("Received Order Payment information: {}", request);

		if (request.status().equals(OrderStatus.DONE) || request.status().equals(OrderStatus.CANCELED)) {
			var response = respository.findByOrderAndOrderPayment(request.idOrder(), request.id());
			if (response.isPresent()) {
				var order = response.get();
				order.update(request.status());
				var orderPayment = respository.save(order);
				appEventGateway.send(new UpdateOrderRequest(orderPayment.getIdOrder(), orderPayment.getStatus()));
				return orderPayment;
			}
		}
		service.excute(request);
		return request;
	}

}
