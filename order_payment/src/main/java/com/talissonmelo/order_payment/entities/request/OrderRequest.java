package com.talissonmelo.order_payment.entities.request;

import com.talissonmelo.order_payment.entities.enums.OrderStatus;

public record OrderRequest(String id, String title, String description, OrderStatus status) {

}
