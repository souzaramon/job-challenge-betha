package com.betha.server.Persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String taxId;

    public Customer() {}

    public Customer(Customer customer) {
        super();

        this.name = customer.getName();
        this.taxId = customer.getTaxId();
    }
}
