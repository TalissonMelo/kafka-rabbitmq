package com.talissonmelo.order_payment.entities.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateOrderPaymentRequest(@Positive(message ="Price is required and positive") BigDecimal price, 
		@NotBlank(message =  "Observation is required") String observation) {

}
