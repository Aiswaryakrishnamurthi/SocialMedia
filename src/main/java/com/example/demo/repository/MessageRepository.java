/*package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.model.msgModel;

@Repository
public interface MessageRepository extends JpaRepository<msgModel , Long>{
	List<msgModel> findBySenderAndReceiver(User sender, User receiver);
    List<msgModel> findByReceiver(User receiver);
}
*/