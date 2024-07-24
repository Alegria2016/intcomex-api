package com.intcomex.api.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "UNIT_PRICE", unique = false, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "QUANTITY", unique = false, nullable = false)
    private Integer quantity;

    @Column(name = "DISCOUNT", unique = false, nullable = false)
    private BigDecimal discount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
