package com.betha.server.Persistence.repositories;

import com.betha.server.Persistence.entities.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}
