package com.example.demo.order;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductService;
import com.example.demo.many2many.usecompositekey.Grade;
import com.example.demo.many2many.usecompositekey.GradeService;
import com.example.demo.many2many.usecompositekey.Student;
import com.example.demo.many2many.usecompositekey.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderApi {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order save(Order order){
        System.out.println(order.getOrderDetailSet());
        return  orderService.save(order);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
