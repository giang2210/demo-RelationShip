package com.example.demo.order;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Product;
import com.example.demo.orderDetail.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="orders")
public class Order extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int customerId;
        private double totalPrice;
        private String shipName;
        private String shipAddress;
        private int shipPhone;
        private int status;
        @OneToMany(mappedBy = "order")
        private Set<OrderDetail> orderDetailSet;
}
