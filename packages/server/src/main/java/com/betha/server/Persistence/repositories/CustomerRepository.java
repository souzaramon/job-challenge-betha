package com.betha.server.Persistence.repositories;

import java.util.Optional;

import com.betha.server.Persistence.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findOneByTaxId(String taxId);
    Optional<Customer> findOneById(Long id);
}
