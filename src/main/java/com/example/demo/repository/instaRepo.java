package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.instaModel;

@Repository
public interface instaRepo extends JpaRepository<instaModel, Integer> {
    @Query("SELECT u FROM instaModel u WHERE u.username = :username AND u.password = :password")
    instaModel checkUser(@Param("username") String username, @Param("password") String password);
}