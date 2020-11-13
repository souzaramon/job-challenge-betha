package com.betha.server.Web.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Role;
import com.betha.server.Persistence.entities.User;
import com.betha.server.Persistence.repositories.RoleRepository;
import com.betha.server.Persistence.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> list() {
        return userRepository.findAll();
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> create(User userAttrs) {
        Optional<User> userOptional = userRepository.findByEmail(userAttrs.getEmail());
        Optional<Role> defaultRole = roleRepository.findOneByName("ROLE_USER");

        if(userOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        String encodedPassword = passwordEncoder.encode(userAttrs.getPassword());

        userAttrs.setPassword(encodedPassword);
        userAttrs.setRoles(Arrays.asList(defaultRole.get()));

        return Optional.ofNullable(userRepository.save(userAttrs));
    }   

    public Optional<User> update(Long id, User userAttrs) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        userAttrs.setId(id);

        return Optional.ofNullable(userRepository.save(userAttrs));
    }   
}
