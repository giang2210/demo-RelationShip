package com.example.demo.entity;

import com.example.demo.order.Category;
import com.example.demo.orderDetail.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "orderId")
    private String name;
    private String description;
    private double price;
    private  int categoryId;

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetailSet;
}
