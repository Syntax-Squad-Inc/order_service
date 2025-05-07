package com.order_service.service.impl;

import org.springframework.transaction.annotation.Transactional;
import com.order_service.dto.OrderDto;
import com.order_service.entity.Order;
import com.order_service.exception.ResourceNotFoundException;
import com.order_service.mapper.OrderMapper;
import com.order_service.repository.OrderRepository;
import com.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        // Convert DTO to entity
        Order order = OrderMapper.mapToOrder(orderDto);

        // Don't set orderNumber here - let @PrePersist handle it
        logger.info("Creating order: {}", order);

        // Save the order
        Order savedOrder = orderRepository.save(order);
        logger.info("Saved order: {}", savedOrder);

        // Convert back to DTO
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::mapToOrderDto)
        .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto updatedOrder) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found with id " + id)
        );

        order.setStatus(updatedOrder.getStatus());
        order.setUpdatedAt(updatedOrder.getUpdatedAt());
        Order updatedOrderObj = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(updatedOrderObj);
    }

    @Override
    public void deleteOrder(int id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found with id " + id)
        );
        orderRepository.deleteById(id);
    }
}
