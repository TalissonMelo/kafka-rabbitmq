package com.talissonmelo.order.rabbitmq.consumer;

import com.talissonmelo.order.entities.Order;
import com.talissonmelo.order.entities.request.UpdateOrderRequest;
import com.talissonmelo.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppUpdatedEventListener implements Consumer<UpdateOrderRequest> {

    private final OrderRepository repository;

    @Override
    public void accept(UpdateOrderRequest request) {
        Order order = repository.findById(request.id()).orElseThrow();
        order.update(request.status());
        repository.save(order);
    }

}
