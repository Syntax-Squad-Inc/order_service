package com.order_service.config; // or com.order_service.util

import com.order_service.entity.Order;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseColumnChecker {
    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(DatabaseColumnChecker.class);

    @PostConstruct
    public void checkColumns() {
        Metamodel metamodel = entityManager.getMetamodel();
        EntityType<Order> entityType = metamodel.entity(Order.class);

        logger.info("Order Entity Mappings:");
        for (Attribute<? super Order, ?> attribute : entityType.getAttributes()) {
            logger.info("Column: {} - Type: {}", attribute.getName(), attribute.getJavaType());
        }
    }
}
