package com.betha.server.Persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betha.server.Persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String username);
}
