package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.editModel;

@Repository
public interface editRepo extends JpaRepository< editModel,Integer> {
	editModel findByUsername(String username);
}
