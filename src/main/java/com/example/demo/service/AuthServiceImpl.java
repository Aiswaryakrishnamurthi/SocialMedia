package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.instaModel;
import com.example.demo.repository.AuthRepo;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepo authRepository;

    @Override
    public boolean authenticate(String username, String password) {
        // Fetch user by username (email)
        instaModel user = authRepository.findByUsername(username);
        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }

}
