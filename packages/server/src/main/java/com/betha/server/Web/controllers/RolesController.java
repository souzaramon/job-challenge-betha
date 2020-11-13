package com.betha.server.Web.controllers;

import java.util.Optional;

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

import com.betha.server.Persistence.entities.Role;
import com.betha.server.Web.services.RolesService;

@RestController
@RequestMapping("/roles")
@Secured({"ROLE_ADMIN"})
public class RolesController {
    
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok(rolesService.list());
    }

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody Role roleAttrs) {
        return ResponseEntity.ok(rolesService.create(roleAttrs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Role roleAttrs) {
        Optional<Role> role = rolesService.update(id, roleAttrs);

        return !role.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(role);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        rolesService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
