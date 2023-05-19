package com.talissonmelo.order_payment.entities.response;

import java.math.BigDecimal;

import com.talissonmelo.order_payment.entities.enums.OrderStatus;

public record OrderPaymentResponse(String id, String idOrder, String title, String description, OrderStatus status,
		BigDecimal price, String observation) {

}
