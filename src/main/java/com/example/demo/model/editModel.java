package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class editModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	   	private String username;
	    private String bio;
	    private String profilePictureUrl;
	    private String gender;
	    
	    
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getProfilePictureUrl() {
			return profilePictureUrl;
		}
		public void setProfilePictureUrl(String profilePictureUrl) {
			this.profilePictureUrl = profilePictureUrl;
		}
		  public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			   public String getGender() {
			        return gender;
			    }

			    public void setGender(String gender) {
			        this.gender = gender;
			    }
	 
	   
	
}
