package com.ps.sg.userservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ps.sg.userservice.entity.User;
import com.ps.sg.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HystrixCommand(fallbackMethod = "userNotFound")
    public User getUser(String userName) {
        return userRepository.findById(userName).orElseThrow(RuntimeException::new);
    }

    public User userNotFound(String userName) {
        return User.builder().userName(userName).accountExpired(true).enabled(false).build();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
