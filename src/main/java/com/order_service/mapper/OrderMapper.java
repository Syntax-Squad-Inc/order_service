package com.order_service.mapper;

import com.order_service.dto.OrderDto;
import com.order_service.entity.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUserId(),
                order.getProductName(),
                order.getPrice(),
                order.getStatus(),
                order.getOrderNumber(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUserId(),
                orderDto.getProductName(),
                orderDto.getPrice(),
                orderDto.getStatus(),
                orderDto.getOrderNumber(),
                orderDto.getCreatedAt(),
                orderDto.getUpdatedAt()
        );
    }
}
