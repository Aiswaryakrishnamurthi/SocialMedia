package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.editModel;

@Service
public interface editService {
	editModel findByUsername(String username);
    void saveProfile(editModel profile);
}
