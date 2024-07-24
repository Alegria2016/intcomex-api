package com.intcomex.api.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "LAST_NAME", unique = false, nullable = false)
    private String lastName;

    @Column(name = "FIRST_NAME", unique = false, nullable = false)
    private String firstName;

    private String title;

    @Column(name = "TITLE_OF_COURTESY")
    private String TitleOfCourtesy;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    private String address;

    private String city;

    private String region;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    private String country;

    @Column(name = "HOME_PHONE")
    private String homePhone;

    private String extension;

    private String photo;

    private String notes;

    @Column(name = "REPORTS_TO")
    private String ReportsTo;


}
