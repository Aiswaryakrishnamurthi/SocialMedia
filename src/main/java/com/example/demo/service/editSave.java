package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.editModel;

public class editSave implements editService {
@Autowired
editService editservice;
	@Override
	public editModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return editservice.findByUsername(username);
	}

	@Override
	public void saveProfile(editModel profile) {
		// TODO Auto-generated method stub
		editservice.saveProfile(profile);
	}

}
