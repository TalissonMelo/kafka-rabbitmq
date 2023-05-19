package com.talissonmelo.order_report.services;

import org.springframework.stereotype.Service;

import com.talissonmelo.order_report.entities.OrderReport;
import com.talissonmelo.order_report.entities.request.OrderReportRequest;
import com.talissonmelo.order_report.repositories.OrderReportRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateOrderReportService {
	
	private final OrderReportRespository respository;

	public void excute(OrderReportRequest request) {
		OrderReport report = OrderReport.createOrderReport(request.title(), request.description(), request.idOrder(), request.id(), request.price(), request.observation());
		respository.save(report);
	}
}
