package com.userDepart.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.userDepart.entities.User;
import com.userDepart.exception.ApiRequestException;
import com.userDepart.repositories.UserRepository;

/**
 *
 * @author Dênis Ronan Sievers
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable long id) {
        Optional<User> result = repository.findById(id);
        return result.orElseThrow(() -> new ApiRequestException("User not found"));
    }

    @PostMapping
    public User insert(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        Optional<User> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new ApiRequestException("User not found");
        } else {
            repository.deleteById(id);
        }
    }
}
