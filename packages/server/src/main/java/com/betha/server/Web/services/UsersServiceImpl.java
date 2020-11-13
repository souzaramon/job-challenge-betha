package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.User;
import com.betha.server.Persistence.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;
    
    public List<User> list() {
        return userRepository.findAll();
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
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
