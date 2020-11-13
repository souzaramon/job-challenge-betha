package com.betha.server.Web.controllers;

import java.util.Optional;

import com.betha.server.Persistence.entities.User;
import com.betha.server.Web.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register/user")
public class RegisterUserController {
    
    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody User userAttrs) {
        Optional<User> user = usersService.create(userAttrs);

        return user.isPresent() 
            ? ResponseEntity.ok(user)
            : ResponseEntity.badRequest().build();
    }
}
