package com.gaurang.mongo.controller;

import com.gaurang.mongo.entity.User;
import com.gaurang.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/findByEmail/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @PutMapping("/updateAgeByEmail/{email}")
    public User updateAgeByEmail(@PathVariable String email) {
        User existingUser = userRepository.findByEmail(email);
        existingUser.setAge(30);
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{email}")
    public User deleteUserByEmail(@PathVariable String email) {
        return userRepository.deleteByEmail(email);
    }

}
