package com.example.demo.order;

import com.example.demo.entity.Product;
import com.example.demo.many2many.usecompositekey.*;
import com.example.demo.orderDetail.OrderDetail;
import com.example.demo.orderDetail.OrderDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();

    }

    public Optional<Order> findById(int orderId) {
        return orderRepository.findById(orderId);
    }
}