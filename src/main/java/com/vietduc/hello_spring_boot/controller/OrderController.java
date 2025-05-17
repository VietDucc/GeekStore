package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.OrderRequest;
import com.vietduc.hello_spring_boot.entity.Order;
import com.vietduc.hello_spring_boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
