package com.betha.server.Web.controllers;

import java.util.Optional;

import com.betha.server.Persistence.entities.Address;
import com.betha.server.Web.services.AddressesService;

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
@RequestMapping("/customers/{id}/addresses")
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class CustomersAddressesController {
    
    @Autowired
    AddressesService addressesService;

    @GetMapping
    public ResponseEntity<Object> index(@PathVariable Long id) {
        return ResponseEntity.ok(addressesService.list(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id) {
        Optional<Address> address = addressesService.get(id);

        return !address.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<Object> store(@PathVariable Long id, @RequestBody Address addressAttrs) {
        Optional<Address> address = addressesService.create(id, addressAttrs);

        return !address.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Address addressAttrs) {
        Optional<Address> address = addressesService.update(id, addressAttrs);

        return !address.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(address);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        addressesService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
