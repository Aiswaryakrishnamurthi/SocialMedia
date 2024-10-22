package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.instaModel;

public interface AuthRepo extends JpaRepository<instaModel, Integer> {
    instaModel findByUsername(String username);

}
