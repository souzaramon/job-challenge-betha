package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Customer;
import com.betha.server.Persistence.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customersService")
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Optional<Customer> get(Long id) {
        return customerRepository.findOneById(id);
    }

    public Optional<Customer> update(Long id, Customer customerAttrs) {
        Optional<Customer> customerOptional = customerRepository.findOneById(id);

        if(!customerOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        customerAttrs.setId(id);

        return Optional.ofNullable(customerRepository.save(customerAttrs));
    }

    public Optional<Customer> create(Customer customerAttrs) {
        Optional<Customer> customerOptional = customerRepository.findOneByTaxId(customerAttrs.getTaxId());

        if(customerOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        return Optional.ofNullable(customerRepository.save(customerAttrs));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
