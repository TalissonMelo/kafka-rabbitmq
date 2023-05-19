package com.talissonmelo.order_report.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talissonmelo.order_report.entities.OrderReport;
import com.talissonmelo.order_report.repositories.OrderReportRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetOrderReportsService {

	private final OrderReportRespository respository;

	public List<OrderReport> excute() {
		return respository.findAll();
	}
}
