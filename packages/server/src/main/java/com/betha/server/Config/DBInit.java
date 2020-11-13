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
        List<Role> roles = roleRepository.findAll();

        if(roles.isEmpty()) {
            Role roleAdmin = new Role("ROLE_ADMIN"); 
            Role roleUser = new Role("ROLE_USER");

            this.roleRepository.save(roleAdmin);
            this.roleRepository.save(roleUser);

            this.userRepository.save(
                new User(
                    "root",
                    "root@root.com",
                    passwordEncoder.encode("root"),
                    Arrays.asList(roleAdmin)
                )
            );
        }
    }
}