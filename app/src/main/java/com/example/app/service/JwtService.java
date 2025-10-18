package com.example.app.service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtService {
    // validate and returns user object from jwt token
    @Autowired
    private UserRepository userRepository;
    public User validateUser(User user) {
        // return user object
        userRepository.findById(user.getId());
        //validation Logic
        return user;
    }
}
