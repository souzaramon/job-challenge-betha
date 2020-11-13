package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Phone;

public interface PhonesService {
    public List<Phone> list(Long customerId);
    public Optional<Phone> get(Long id);   
    public Optional<Phone> create(Long customerId, Phone addressAttrs);
    public Optional<Phone> update(Long customerId, Phone addressAttrs);
    public void delete(Long id);
}
