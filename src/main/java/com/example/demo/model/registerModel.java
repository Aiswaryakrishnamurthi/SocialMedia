package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="registration_data")
public class registerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email address")
	private String mob;
	
	
	@NotEmpty(message = "Fullname is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String fname;
	

	@NotEmpty(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String uname;
	
	 
	 @NotEmpty(message = "Password is required")
	 @Size(min = 6, message = "Password must be at least 6 characters long")
	private String pass;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}	
	
	

	


}
