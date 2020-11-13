package com.betha.server.Persistence.repositories;

import java.util.List;
import java.util.Optional;
import com.betha.server.Persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
    public List<Address> findAllByCustomerId(Long customerId);
    public Optional<Address> findOneByCustomerId(Long id);
    Optional<Address> findOneById(Long id);
}
