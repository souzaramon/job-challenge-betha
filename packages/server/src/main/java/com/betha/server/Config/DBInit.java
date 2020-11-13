package com.betha.server.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

import com.betha.server.Persistence.entities.Role;
import com.betha.server.Persistence.entities.User;
import com.betha.server.Persistence.repositories.RoleRepository;
import com.betha.server.Persistence.repositories.UserRepository;


@Component
public class DBInit implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> users = userRepository.findAll();

        if(users.isEmpty()) {
            this.createUser("root", "r@r.com", passwordEncoder.encode("123"), "ROLE_ADMIN");
        }
    }

    public void createUser(String name, String email, String password, String roleName) {
        Role role = new Role();
        role.setName(roleName);

        this.roleRepository.save(role);

        User user = new User(name, email, password, Arrays.asList(role));

        this.userRepository.save(user);
    }
}