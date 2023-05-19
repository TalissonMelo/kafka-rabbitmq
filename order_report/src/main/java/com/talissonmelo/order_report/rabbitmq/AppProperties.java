package com.talissonmelo.order_report.rabbitmq;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AppProperties {
	private String appUpdatedChannel = "appUpdatedSupplier-out-0";
}
