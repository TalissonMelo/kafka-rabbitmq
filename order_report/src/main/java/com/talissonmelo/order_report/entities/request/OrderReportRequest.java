package com.talissonmelo.order_report.entities.request;

import java.math.BigDecimal;

import com.talissonmelo.order_report.entities.enums.OrderStatus;

public record OrderReportRequest(String id, String idOrder, String title, String description, OrderStatus status, BigDecimal price, String observation) {

}
