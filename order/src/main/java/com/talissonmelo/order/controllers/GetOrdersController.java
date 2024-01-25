package com.talissonmelo.order.controllers;

import com.talissonmelo.order.entities.Order;
import com.talissonmelo.order.service.GetOrdersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Order")
public class GetOrdersController {

    private final GetOrdersService service;

    @GetMapping("/v1/orders")
    public ResponseEntity<Page<Order>> execute(@PageableDefault(size = 5) Pageable pageable) {
        Page<Order> response = service.execute(pageable);
        return ResponseEntity.status(200).body(response);
    }
}
