package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SUPPLIERS")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "COMPANY_NAME", unique = false, nullable = false)
    private String companyName;

    @Column(name = "CONTACT_NAME", unique = false, nullable = false)
    private String contactName;

    @Column(name = "CONTACT_TITLE", unique = false, nullable = false)
    private String contactTitle;

    private String address;

    private String city;

    @Column(name = "POSTAL_CODE", unique = false, nullable = false)
    private String postalCode;

    private String country;

    private String phone;

    private String fax;

    private String homePage;


    //@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    //private List<Product> products = new ArrayList<>();
}
