package com.betha.server.Persistence.repositories;

import java.util.Optional;

import com.betha.server.Persistence.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Optional<Role> findOneById(Long id);
    public Optional<Role> findOneByName(String name);
}
