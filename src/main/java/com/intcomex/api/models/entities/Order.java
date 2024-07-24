package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "ORDER_DATE", unique = false, nullable = false)
    private Date orderDate;

    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

    @Column(name = "SHIPPED_VIA")
    private String shippedVia;

    @Column(name = "FREIGHT")
    private String freight;

    @Column(name = "SHIP_NAME")
    private String shipName;

    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;

    @Column(name = "SHIP_CITY")
    private String shipCity;

    @Column(name = "SHIP_REGION")
    private String shipRegion;

    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;

    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
