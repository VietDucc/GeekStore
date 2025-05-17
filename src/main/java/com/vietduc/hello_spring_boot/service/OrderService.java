package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.config.sendemail.EmailService;
import com.vietduc.hello_spring_boot.dto.request.AddressRequest;
import com.vietduc.hello_spring_boot.dto.request.OrderItemRequest;
import com.vietduc.hello_spring_boot.dto.request.OrderRequest;
import com.vietduc.hello_spring_boot.entity.*;
import com.vietduc.hello_spring_boot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private AddressService addressService;
    @Autowired private EmailService emailService;

    public Order createOrder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = addressService.saveOrGetAddress(request.getAddress());

        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setTotalPrice(request.getTotalPrice());
        order.setCreatedAt(LocalDateTime.now());

        // Nếu client truyền tên/email/phone riêng, ưu tiên dùng cái đó
        order.setUserName(request.getUserName() != null ? request.getUserName() : user.getName());
        order.setUserEmail(request.getUserEmail() != null ? request.getUserEmail() : user.getEmail());
        order.setUserPhone(request.getUserPhone() != null ? request.getUserPhone() : user.getPhone());

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + itemRequest.getProductId()));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setSize(itemRequest.getSize());
            item.setColor(itemRequest.getColor());
            item.setQuantity(itemRequest.getQuantity());
            item.setUnitPrice(itemRequest.getUnitPrice());

            orderItems.add(item);
        }
        order.setItems(orderItems);

        Order savedOrder = orderRepository.save(order);

        // Gửi email xác nhận đơn hàng bất đồng bộ
        String subject = "Order Confirmation - Order #" + savedOrder.getId();
        String body = "Dear " + savedOrder.getUserName() + ",\n\n" +
                "Thank you for your order! Your order ID is " + savedOrder.getId() + ".\n" +
                "Total amount: " + savedOrder.getTotalPrice() + "\n\n" +
                "We will process your order soon.\n\n" +
                "Best regards,\nGeekUp Store";

        emailService.sendOrderConfirmationEmail(savedOrder.getUserEmail(), subject, body);

        return savedOrder;
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
