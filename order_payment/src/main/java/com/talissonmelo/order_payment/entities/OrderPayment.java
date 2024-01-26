package com.talissonmelo.order_payment.entities;

import com.talissonmelo.order_payment.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_payments")
public class OrderPayment {

    @Id
    private final String id = UUID.randomUUID().toString();

    private String idOrder;
    private String title;
    private String description;
    private OrderStatus status;
    private BigDecimal price;
    private String observation;

    private OrderPayment(String title, String description, String idOrder) {
        this.title = title;
        this.description = description;
        this.observation = "";
        this.idOrder = idOrder;
        this.price = BigDecimal.ZERO;
        this.status = OrderStatus.ANALYZING;
    }

    public static OrderPayment createOrder(String title, String description, String idOrder) {
        return new OrderPayment(title, description, idOrder);
    }

    public OrderPayment update(BigDecimal price, String observation) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = toPrice(price);
            ;
        }
        this.status = OrderStatus.IN_PROGRESS;
        this.observation = observation;
        return this;
    }

    private boolean isValidStatus() {
        if (this.status.equals(OrderStatus.IN_PROGRESS) == false) {
            throw new IllegalArgumentException("A Order Payment in status: " + status);
        }
        return true;
    }

    public OrderPayment toDone() {
        this.isValidStatus();
        this.status = OrderStatus.DONE;
        return this;
    }

    public OrderPayment toCanceled() {
        this.isValidStatus();
        this.status = OrderStatus.CANCELED;
        return this;
    }

    @SuppressWarnings("deprecation")
    private BigDecimal toPrice(BigDecimal price) {
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}