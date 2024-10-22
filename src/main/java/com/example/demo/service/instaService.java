package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.model.instaModel;
import com.example.demo.model.registerModel;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.instaRepo;
import com.example.demo.repository.registerInterface;

@Service
public class instaService implements instaInterface ,ProfileService{
	
@Autowired
instaRepo instarepo;

@Autowired
registerInterface repo;

    @Override
	public void usersave(String user, String pass) {
		
    	instaModel instalogin = new instaModel();
    	instalogin.setUsername(user);
    	instalogin.setPassword(pass);
    	instarepo.save(instalogin);
}
       @Override
       public void regSave(String mob, String fname, String uname, String password) {
          registerModel RegisterModel = new registerModel();
          RegisterModel.setMob(mob);
          RegisterModel.setFname(fname);
          RegisterModel.setUname(uname);
          RegisterModel.setPass(password);
          repo.save(RegisterModel);
      }
       public boolean isUsernameUnique(String uname) {
           return repo.findByUname(uname, uname) == null;
       }
       
       
	public boolean isValidUser(String user, String pass) {
		// TODO Auto-generated method stub
		  registerModel user1 = repo.findByUname(user, pass);
	        return user1 != null && user1.getPass().equals(pass);
	}
	/*@Override
	public instaModel checkUser(String user, String pass) {
		instaModel Instamodel = new instaModel();
		Instamodel.getUsername();
		Instamodel.getUsername();
		return Instamodel.checkUser(Instamodel);
	}*/
	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		instaModel instamodel = instarepo.checkUser(username, password);
		return instamodel != null;
	}
	 public instaModel checkUser( instaModel user) {
		 instaModel obj = instarepo.checkUser(user.getUsername(),user.getPassword());
		 return obj;
	 }
	 
	 @Autowired
	    private ProfileRepository profileRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public Profile findByUsername(String username) {
	        // Check for null or empty username
	        if (username == null || username.isEmpty()) {
	            throw new IllegalArgumentException("Username cannot be null or empty.");
	        }

	        // Retrieve the profile using the repository
	        Optional<Profile> profileOpt = profileRepository.findByUsername(username);
	        return profileOpt.orElse(null);
	    }

	    @Override
	    public Profile updateProfile(Profile profile) {
	        return profileRepository.save(profile); // Save updated profile
	    }

	    @Override
	    public Profile getProfileByUserId(Long userId) {
	        return profileRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("Profile not found"));
	    }

	    @Override
	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }
	    public boolean isValidUser1(String username, String password) {
	        // Assuming you have a UserRepository to interact with the database
	        User user = userRepository.findByUsername(username);

	        // Check if user exists and password matches
	        return user != null && user.getPassword().equals(password);
	    }
	    public Profile getProfile() {
	        // Fetch the profile from the database
	        return profileRepository.findById(1L).orElse(new Profile());
	    }

	  
  }
	

