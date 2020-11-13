package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Address;
import com.betha.server.Persistence.entities.Customer;
import com.betha.server.Persistence.repositories.AddressRepository;
import com.betha.server.Persistence.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressesService")
public class AddressesServiceImplt implements AddressesService {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Address> list(Long customerId) {
        return addressRepository.findAllByCustomerId(customerId);
    }

    public Optional<Address> get(Long id) {
        return addressRepository.findOneByCustomerId(id);
    }

    public Optional<Address> create(Long customerId, Address addressAttrs) {
        Optional<Customer> customerOptional = customerRepository.findOneById(customerId);

        if(!customerOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        addressAttrs.setCustomer(customerOptional.get());        

        return Optional.ofNullable(addressRepository.save(addressAttrs));
    };

    public Optional<Address> update(Long id, Address addressAttrs) {
        Optional<Address> addressOptional = addressRepository.findOneById(id);

        if(!addressOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        addressAttrs.setId(id);        

        return Optional.ofNullable(addressRepository.save(addressAttrs));
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
