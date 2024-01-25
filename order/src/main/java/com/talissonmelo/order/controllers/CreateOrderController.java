package com.talissonmelo.order.controllers;

import com.talissonmelo.order.entities.request.OrderRequest;
import com.talissonmelo.order.entities.response.OrderResponse;
import com.talissonmelo.order.kafka.KafkaProducerMessage;
import com.talissonmelo.order.service.CreateOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Order")
public class CreateOrderController {

    private final CreateOrderService service;


    @PostMapping("/v1/orders")
    public ResponseEntity<OrderResponse> execute(@Valid @RequestBody OrderRequest request) {
        OrderResponse response = service.execute(request);

        return ResponseEntity.status(201).body(response);
    }

}
