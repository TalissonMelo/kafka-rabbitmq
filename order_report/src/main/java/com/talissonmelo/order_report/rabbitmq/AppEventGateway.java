package com.talissonmelo.order_report.rabbitmq;

import com.talissonmelo.order_report.entities.request.UpdateOrder;

public interface AppEventGateway {
    void send(UpdateOrder updateOrder );
}