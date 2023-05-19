package com.talissonmelo.order_report.entities.request;

import com.talissonmelo.order_report.entities.enums.OrderStatus;

public record UpdateOrder (String id, OrderStatus status) {

}
