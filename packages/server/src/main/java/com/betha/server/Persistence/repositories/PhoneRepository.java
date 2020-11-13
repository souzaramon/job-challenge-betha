package com.betha.server.Persistence.repositories;

import com.betha.server.Persistence.entities.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {}
