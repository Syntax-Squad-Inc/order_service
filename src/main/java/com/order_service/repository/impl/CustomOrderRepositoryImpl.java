package com.order_service.repository.impl;

import com.order_service.entity.Order;
import com.order_service.repository.CustomOrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomOrderRepositoryImpl implements CustomOrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void refresh(Order order) {
        entityManager.refresh(order);
    }
}
