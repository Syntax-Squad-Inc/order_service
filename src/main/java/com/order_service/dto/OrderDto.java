package com.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    private int userId;
    private String productName;
    private BigDecimal price;
    private String status;
    private Long orderNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
