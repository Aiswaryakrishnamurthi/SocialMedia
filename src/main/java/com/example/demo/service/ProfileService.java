package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.model.Profile;
import com.example.demo.model.User;


@Service
public interface ProfileService {
    Profile findByUsername(String username);
    Profile updateProfile(Profile profile);
    Profile getProfileByUserId(Long userId);
	User findByEmail(String name);
	Profile getProfile();
	
}

