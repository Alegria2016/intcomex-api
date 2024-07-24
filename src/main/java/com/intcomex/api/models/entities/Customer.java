package com.intcomex.api.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "COMPANY_NAME", unique = false, nullable = false)
    private String companyName;

    @Column(name = "CONTACT_NAME", unique = false, nullable = false)
    private String contactName;

    @Column(name = "CONTACT_TITLE")
    private String contactTitle;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    private String region;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    private String country;

    private String phone;

    private String fax;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
