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

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);

        // Force refresh to get orderNumber from DB
        orderRepository.flush(); // Flush first to persist
        orderRepository.refresh(savedOrder); // Then refresh the entity to load generated values

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
