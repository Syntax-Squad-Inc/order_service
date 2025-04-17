package com.order_service.repository;

import com.order_service.entity.Order;

public interface CustomOrderRepository {
    void refresh(Order order);
}
