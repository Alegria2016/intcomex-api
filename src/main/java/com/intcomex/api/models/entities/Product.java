package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "PRODUCT_NAME", unique = false, nullable = false)
    private String productName;

    @Column(name = "QUANTITY_PER_UNIT", unique = false, nullable = false)
    private Integer quantityPerUnit;

    @Column(name = "UNIT_PRICE", unique = false, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "UNITS_IN_STOCK", unique = false, nullable = false)
    private Integer unitsInStock;

    @Column(name = "UNITS_ON_ORDER", unique = false, nullable = false)
    private Integer unitsOnOrder;

    @Column(name = "REORDER_LEVEL", unique = false, nullable = false)
    private int reorderLevel;

    @Column(name = "DISCONTINUED", nullable = true)
    private int discontinued;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "supplier_id")
    //private Supplier supplier;
    private Long supplierId;
}
