package com.order_service.Controller;

import com.order_service.Model.Order;
import com.order_service.Service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order API", description = "API for managing orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    @Operation(
        summary = "Get an order by ID",
        description = "Retrieve an order by its unique ID. \n\n"
                    + "Example Use Case:\n"
                    + "A user wants to view the details of a specific order. They provide the order ID, "
                    + "and the system returns the order details, such as the order ID, user ID, amount, and status."
    )
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping
    @Operation(
        summary = "Get all orders",
        description = "Retrieve a list of all orders in the system. \n\n"
                    + "Example Use Case:\n"
                    + "An admin wants to view all orders placed in the system. This endpoint returns a list of all orders, "
                    + "including their IDs, user IDs, amounts, and statuses."
    )
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @Operation(
        summary = "Create a new order",
        description = "Add a new order to the system. \n\n"
                    + "Example Use Case:\n"
                    + "A user places a new order. They provide the order details, such as the user ID, amount, and status. "
                    + "The system saves the order and returns the created order with a unique ID."
    )
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update an existing order",
        description = "Update the details of an existing order by its ID. \n\n"
                    + "Example Use Case:\n"
                    + "A user wants to update the status of an order (e.g., from 'Pending' to 'Confirmed'). "
                    + "They provide the order ID and the updated details, and the system updates the order."
    )
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete an order by ID",
        description = "Remove an order from the system by its unique ID. \n\n"
                    + "Example Use Case:\n"
                    + "An admin wants to delete an order that was placed in error. They provide the order ID, "
                    + "and the system deletes the order from the database."
    )
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
