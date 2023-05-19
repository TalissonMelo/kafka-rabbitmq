package com.talissonmelo.order_report.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.order_report.entities.OrderReport;
import com.talissonmelo.order_report.services.GetOrderReportsService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Order Report")
public class GetOrderReportController {

	private final GetOrderReportsService service;

	@GetMapping("/v1/orders-reports")
	public ResponseEntity<List<OrderReport>> excute() {
		var response = service.excute();
		return ResponseEntity.status(200).body(response);
	}
}
