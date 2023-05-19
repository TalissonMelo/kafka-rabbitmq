package com.talissonmelo.order_report.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talissonmelo.order_report.entities.OrderReport;

public interface OrderReportRespository extends JpaRepository<OrderReport, String> {

	@Query(value = "SELECT rep.* FROM order_reports rep WHERE rep.id_order = :idOrder and rep.id_order_payment = :idOrderPayment", nativeQuery = true)
	Optional<OrderReport> findByOrderAndOrderPayment(String idOrder, String idOrderPayment);

}
