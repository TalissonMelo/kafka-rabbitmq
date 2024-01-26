package com.talissonmelo.order_payment.entities.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public record UpdateOrderPaymentRequest(@Positive(message = "Price is required and positive") BigDecimal price,
                                        @NotBlank(message = "Observation is required") String observation) {

}
