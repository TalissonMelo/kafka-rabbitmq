package com.talissonmelo.order_report.entities.request;

import com.talissonmelo.order_report.entities.enums.OrderStatus;

public record UpdateOrderRequest (String id, OrderStatus status) {

}
