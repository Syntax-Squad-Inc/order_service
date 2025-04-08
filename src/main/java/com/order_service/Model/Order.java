package com.order_service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders") // Added table name annotation
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Added nullable constraint
    private String orderId;

    @Column(nullable = false) // Added nullable constraint
    private Long userId;

    @Column(nullable = false) // Added nullable constraint
    private Double amount;

    @Column(nullable = false) // Added nullable constraint
    private String status;
}
