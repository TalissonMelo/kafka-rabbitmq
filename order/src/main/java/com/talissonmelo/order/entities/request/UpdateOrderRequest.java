package com.talissonmelo.order.entities.request;

import com.talissonmelo.order.entities.enums.OrderStatus;

public record UpdateOrderRequest (String id, OrderStatus status) {

}
