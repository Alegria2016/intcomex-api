package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CATEGORY_NAME", unique = false, nullable = false)
    private String categoryName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PICTURE")
    private String picture;
}
