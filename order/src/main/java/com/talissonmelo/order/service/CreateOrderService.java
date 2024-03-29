package com.talissonmelo.order.service;

import com.talissonmelo.order.entities.Order;
import com.talissonmelo.order.entities.request.OrderRequest;
import com.talissonmelo.order.entities.response.OrderResponse;
import com.talissonmelo.order.kafka.KafkaProducerMessage;
import com.talissonmelo.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderService {

    private final OrderRepository repository;
    private final KafkaProducerMessage kafkaProducerMessage;

    public OrderResponse execute(OrderRequest request) {
        log.info("Create de Order");
        Order order = Order.createOrder(request.title(), request.description());
        OrderResponse response = toOrderResponse(repository.save(order));
        kafkaProducerMessage.sendMessage(response);
        return response;

    }

    private OrderResponse toOrderResponse(Order order) {

        return new OrderResponse(order.getId(), order.getTitle(), order.getDescription(), order.getStatus());
    }
}
