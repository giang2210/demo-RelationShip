package com.example.demo.orderDetail;


import com.example.demo.entity.Product;
import com.example.demo.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private  Product product;
    // thông tin thêm.
    private int quantity;
    private double unitPrice;
}
