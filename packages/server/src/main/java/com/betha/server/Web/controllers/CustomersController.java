package com.betha.server.Web.controllers;

import java.util.Optional;

import com.betha.server.Persistence.entities.Customer;
import com.betha.server.Web.services.CustomersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class CustomersController {
    
    @Autowired
    CustomersService customersService;

    @GetMapping
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok(customersService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id) {
        Optional<Customer> customer = customersService.get(id);

        return !customer.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody Customer customerAttrs) {
        Optional<Customer> customer = customersService.create(customerAttrs);

        return !customer.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Customer customerAttrs) {
        Optional<Customer> customer = customersService.update(id, customerAttrs);

        return !customer.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        customersService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
