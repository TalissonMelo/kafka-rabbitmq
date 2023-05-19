package com.talissonmelo.order_report.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.talissonmelo.order_report.entities.enums.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_reports")
public class OrderReport {

	@Id
	private final String id = UUID.randomUUID().toString();

	private String idOrder;
	private String idOrderPayment;
	private String title;
	private String description;
	private OrderStatus status;
	private BigDecimal price;
	private String observation;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	private OrderReport(String title, String description, String idOrder, String idOrderPayment, BigDecimal price, String observation) {
		this.title = title;
		this.description = description;
		this.observation = observation;
		this.idOrder = idOrder;
		this.idOrderPayment = idOrderPayment;
		this.price = toPrice(price);
		this.status = OrderStatus.IN_PROGRESS;
		this.updatedAt = LocalDateTime.now();
	}

	@SuppressWarnings("deprecation")
	private BigDecimal toPrice(BigDecimal price) {
		return price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public static OrderReport createOrderReport(String title, String description, String idOrder, String idOrderPayment, BigDecimal price, String observation) {
		return new OrderReport(title, description, idOrder, idOrderPayment, price, observation);
	}
	
	public OrderReport update(OrderStatus status) {
		this.status = status;
		this.updatedAt = LocalDateTime.now();
		return this;
	}

}