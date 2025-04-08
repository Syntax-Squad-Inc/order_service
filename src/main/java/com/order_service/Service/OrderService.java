package com.order_service.Service;

import com.order_service.Model.Order;
import java.util.List;

public interface OrderService {
    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
