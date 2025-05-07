package com.order_service.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private BigDecimal price;

    @Column(name = "status")
    private String status;

    @Column(name = "order_number", unique = true)  // Removed redundant @Getter @Setter
    @SequenceGenerator(name = "order_number_seq", sequenceName = "order_number_seq", initialValue = 1000, allocationSize = 1)
    private Long orderNumber;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private static final AtomicLong sequenceNumber = new AtomicLong(1000);
    private static final Logger logger = LoggerFactory.getLogger(Order.class);

    // Add this constructor to match your OrderMapper
    public Order(int id,
                 int userId,
                 String productName,
                 BigDecimal price,
                 String status,
                 Long orderNumber,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.orderNumber = orderNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        logger.info("PrePersist called");
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.orderNumber == null) {
            this.orderNumber = sequenceNumber.getAndIncrement();
            logger.info("Generated orderNumber: {}", this.orderNumber);
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}