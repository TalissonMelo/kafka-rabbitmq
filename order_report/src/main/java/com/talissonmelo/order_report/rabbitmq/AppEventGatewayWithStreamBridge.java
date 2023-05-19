package com.talissonmelo.order_report.rabbitmq;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.talissonmelo.order_report.entities.request.UpdateOrderRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppEventGatewayWithStreamBridge implements AppEventGateway {

	private final StreamBridge streamBridge;
	private final AppProperties appProperties;

	@Override
	public void send(UpdateOrderRequest order) {
		log.info("USANDO EVENTOS/MENSAGENS RABBIT_MQ - Producer Order PUT information: {}", order);
		streamBridge.send(appProperties.getAppUpdatedChannel(), order);
	}

}
