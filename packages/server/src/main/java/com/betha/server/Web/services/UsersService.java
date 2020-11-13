package com.betha.server.Web.services;

import java.util.List;
import java.util.Optional;

import com.betha.server.Persistence.entities.User;

public interface UsersService {
    public List<User> list();
    public Optional<User> get(Long id);
    public Optional<User> update(Long id, User userAttrs);
}
