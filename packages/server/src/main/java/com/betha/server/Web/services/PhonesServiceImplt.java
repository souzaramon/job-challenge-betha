package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Customer;
import com.betha.server.Persistence.entities.Phone;
import com.betha.server.Persistence.repositories.CustomerRepository;
import com.betha.server.Persistence.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("phonesService")
public class PhonesServiceImplt implements PhonesService {
   
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PhoneRepository phoneRepository;

    public List<Phone> list(Long customerId) {
        return phoneRepository.findAllByCustomerId(customerId);
    }

    public Optional<Phone> get(Long id) {
        return phoneRepository.findOneByCustomerId(id);
    }      

    public Optional<Phone> create(Long customerId, Phone phoneAttrs) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if(!customerOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        phoneAttrs.setCustomer(customerOptional.get());        

        return Optional.ofNullable(phoneRepository.save(phoneAttrs));
    };

    public Optional<Phone> update(Long id, Phone phoneAttrs) {
        Optional<Phone> phoneOptional = phoneRepository.findOneById(id);

        if(!phoneOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        phoneAttrs.setId(id);        

        return Optional.ofNullable(phoneRepository.save(phoneAttrs));
    }

    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }
}
