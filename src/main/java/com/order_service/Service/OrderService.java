package com.order_service.service;

import com.order_service.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
