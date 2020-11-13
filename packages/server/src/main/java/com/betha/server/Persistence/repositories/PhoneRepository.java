package com.betha.server.Persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    public List<Phone> findAllByCustomerId(Long customerId);
    public Optional<Phone> findOneByCustomerId(Long id);
    Optional<Phone> findOneById(Long id);
}
