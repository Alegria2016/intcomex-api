package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SHIPPERS")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "COMPANY_NAME", unique = false, nullable = false)
    private String companyName;

    @Column(name = "PHOTO", unique = false, nullable = true)
    private String photo;

    @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
