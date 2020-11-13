package com.betha.server.Persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.betha.server.Persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByEmail(String username);
}
