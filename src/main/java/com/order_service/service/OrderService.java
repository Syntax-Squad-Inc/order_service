package com.order_service.service;

import com.order_service.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(int id);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(int id, OrderDto updatedOrder);

    void deleteOrder(int id);
}
