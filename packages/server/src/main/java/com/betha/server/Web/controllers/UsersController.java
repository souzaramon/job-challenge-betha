package com.betha.server.Web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betha.server.Persistence.entities.User;
import com.betha.server.Web.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService usersService;

    @GetMapping
    public List<User> index() {
        return usersService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id) {
        Optional<User> user = usersService.get(id);

        return !user.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody User userAttrs) {
        Optional<User> user = usersService.update(id, userAttrs);

        return !user.isPresent()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(user);
    }
}
