package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.Role;

public interface RolesService {
    public List<Role> list();
    public Role create(Role role);
    public Optional<Role> update(Long id, Role roleAttrs);
    public void delete(Long id);
}
