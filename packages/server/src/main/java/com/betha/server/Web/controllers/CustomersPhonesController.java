package com.betha.server.Web.controllers;

import java.util.Optional;

import com.betha.server.Persistence.entities.Phone;
import com.betha.server.Web.services.PhonesService;

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
@RequestMapping("/customers/{id}/phones")
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class CustomersPhonesController {
    
    @Autowired
    PhonesService phonesService;

    @GetMapping
    public ResponseEntity<Object> index(@PathVariable Long id) {
        return ResponseEntity.ok(phonesService.list(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id) {
        Optional<Phone> phone = phonesService.get(id);

        return !phone.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(phone);
    }

    @PostMapping
    public ResponseEntity<Object> store(@PathVariable Long id, @RequestBody Phone phoneAttrs) {
        Optional<Phone> phone = phonesService.create(id, phoneAttrs);

        return !phone.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(phone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Phone phoneAttrs) {
        Optional<Phone> phone = phonesService.update(id, phoneAttrs);

        return !phone.isPresent()
            ? ResponseEntity.badRequest().build()
            : ResponseEntity.ok(phone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        phonesService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
