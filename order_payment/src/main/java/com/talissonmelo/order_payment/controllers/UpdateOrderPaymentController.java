package com.talissonmelo.order_payment.controllers;

import com.talissonmelo.order_payment.entities.request.UpdateOrderPaymentRequest;
import com.talissonmelo.order_payment.entities.response.OrderPaymentResponse;
import com.talissonmelo.order_payment.kafka.producer.KafkaProducerMessage;
import com.talissonmelo.order_payment.services.UpdateOrderPaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "OrderPayment")
public class UpdateOrderPaymentController {

    private final UpdateOrderPaymentService service;
    private final KafkaProducerMessage kafkaProducerMessage;

    @PutMapping("/v1/orders-payments/{orderPaymentId}")
    public ResponseEntity<OrderPaymentResponse> execute(@PathVariable String orderPaymentId,
                                                        @Valid @RequestBody UpdateOrderPaymentRequest request) {

        var response = service.execute(orderPaymentId, request);

        log.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Order Payment PUT information: {}", response);
        kafkaProducerMessage.sendMessage(response);

        return ResponseEntity.status(200).body(response);
    }

}
