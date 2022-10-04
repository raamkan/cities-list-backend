package com.challenge.citylists.controller;

import com.challenge.citylists.common.Constants;
import com.challenge.citylists.entity.User;
import com.challenge.citylists.exception.ExceptionBroker;
import com.challenge.citylists.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/addingUser")
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String joinGroup(@RequestBody User user) {
        user.setRoles(Constants.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user.getUsername() + "Successfully Added ";
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> loadUsers() {
        return repository.findAll();
    }

}
