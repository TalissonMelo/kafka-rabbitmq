package com.talissonmelo.order.entities;

import com.talissonmelo.order.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private final String id = UUID.randomUUID().toString();

    private String title;
    private String description;
    private OrderStatus status;

    private Order(String title, String description) {
        super();
        this.title = title;
        this.description = description;
        this.status = OrderStatus.INITIAL;
    }

    public static Order createOrder(String title, String description) {
        return new Order(title, description);
    }

    public Order update(OrderStatus status) {
        this.status = status;
        return this;
    }
}
