package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Address;

public interface AddressesService {
    public List<Address> list(Long customerId);
    public Optional<Address> get(Long id);
    public Optional<Address> create(Long customerId, Address addressAttrs);
    public Optional<Address> update(Long customerId, Address addressAttrs);
    public void delete(Long id);
}
