package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Role;
import com.betha.server.Persistence.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rolesService")
public class RolesServuceImpl implements RolesService {
    @Autowired
    RoleRepository roleRepository;
    
    public List<Role> list() {
        return roleRepository.findAll();
    }
    
    public Role create(Role role) {
        return roleRepository.save(role);
    }
    
    public Optional<Role> update(Long id, Role roleAttrs) {
        Optional<Role> roleOptional = roleRepository.findOneById(id);

        if(!roleOptional.isPresent()) {
            return Optional.ofNullable(null);
        }

        roleAttrs.setId(id);

        return Optional.ofNullable(roleRepository.save(roleAttrs));
    }
    
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
