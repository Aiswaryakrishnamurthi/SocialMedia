package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.registerModel;


@Service
public interface UserService {
    User findByEmail(String email);
    boolean isUsernameUnique(String username);

    void saveUser(registerModel registrationData);
}
