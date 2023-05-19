package com.talissonmelo.order.entities.response;

import com.talissonmelo.order.entities.enums.OrderStatus;

public record OrderResponse(String id, String title, String description, OrderStatus status) {

}
