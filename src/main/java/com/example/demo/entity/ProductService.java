package com.example.demo.entity;

import com.example.demo.many2many.usecompositekey.*;
import com.example.demo.order.Order;
import com.example.demo.orderDetail.OrderDetail;
import com.example.demo.orderDetail.OrderDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;    public Product save(Product product){
        productRepository.save(product);
        return  product;
    }
    public List<Product> findAll(){
        return productRepository.findAll();

    }
    public Optional<Product> findById(int productId){
        return productRepository.findById(productId);
    }
    public  boolean addProductToClass(Product product, Order order){
        try {
            Set<OrderDetail> orderDetails = product.getOrderDetailSet();
            if (orderDetails == null){
                orderDetails = new HashSet<>();
            }
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(new OrderDetailId(order.getId(), product.getId()));
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            product.setOrderDetailSet(orderDetails);
            productRepository.save(product);
        }catch (Exception e){
            return  false;
        }
        return true;
    }
}
