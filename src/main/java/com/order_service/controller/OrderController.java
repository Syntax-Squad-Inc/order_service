package com.order_service.controller;

import com.order_service.dto.OrderDto;
import com.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    // Build Add Order REST API
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Build Get Order REST API
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderBy(@PathVariable("id") int id){
        OrderDto orderDto = orderService.getOrderById(id);
        return ResponseEntity.ok(orderDto);
    }

    // Build Get All Orders REST API
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Build Update Order REST API
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") int id, @RequestBody OrderDto updatedOrder){
        OrderDto orderDto = orderService.updateOrder(id, updatedOrder);
        return ResponseEntity.ok(orderDto);
    }

    // Build Delete Order REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") int id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted");
    }
}
