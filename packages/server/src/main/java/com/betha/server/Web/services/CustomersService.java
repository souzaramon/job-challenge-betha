package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Customer;

public interface CustomersService {
    public List<Customer> list();
    public Optional<Customer> get(Long id);
    public Optional<Customer> update(Long id, Customer customerAttrs);
    public Optional<Customer> create(Customer customerAttrs);
    public void delete(Long id);
}
