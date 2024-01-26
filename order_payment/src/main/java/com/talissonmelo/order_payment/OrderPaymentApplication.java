package com.talissonmelo.order_payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPaymentApplication.class, args);
	}

}
