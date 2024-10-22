package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.demo.model.editModel;
import com.example.demo.model.registerModel;


@Repository
public interface registerInterface extends JpaRepository<registerModel, Integer> {
    @Query("SELECT u FROM registerModel u WHERE u.uname = :uname AND u.pass = :pass")
    registerModel findByUname(@Param("uname") String uname, @Param("pass") String pass);
}


