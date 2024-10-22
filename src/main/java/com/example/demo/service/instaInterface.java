package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.model.instaModel;

//import com.example.demo.model.instaModel;

@Service
public interface instaInterface {
	public void usersave (String user, String pass);

	public boolean authenticate(String username, String password);
	public instaModel checkUser( instaModel user);
	public void regSave(String mob, String fname, String uname, String password);
	public interface ProfileService {
	    Profile findByUsername(String username);
	    Profile updateProfile(Profile profile);
	    Profile getProfileByUserId(Long userId);
	    User findByEmail(String email);  // Added method to handle User operations
	}

}
