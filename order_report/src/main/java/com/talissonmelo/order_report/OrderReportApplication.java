package com.talissonmelo.order_report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderReportApplication.class, args);
	}

}
