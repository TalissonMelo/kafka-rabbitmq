package com.talissonmelo.order_report.rabbitmq;

import com.talissonmelo.order_report.entities.request.UpdateOrderRequest;

public interface AppEventGateway {
    void send(UpdateOrderRequest updateOrder );
}