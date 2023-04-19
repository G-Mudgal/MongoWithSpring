package com.gaurang.mongo.controller;

import com.gaurang.mongo.entity.User;
import com.gaurang.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/")
    public List<User> addUser() {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().name("John Doe").email("johndoe@example.com").age(30).build());
        userList.add(User.builder().name("Jane Smith").email("janesmith@example.com").age(25).build());
        userList.add(User.builder().name("Bob Johnson").email("bobjohnson@example.com").age(40).build());
        return userRepository.saveAll(userList);
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
