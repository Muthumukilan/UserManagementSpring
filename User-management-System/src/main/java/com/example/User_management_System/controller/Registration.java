package com.example.User_management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_management_System.model.UserLogin;
import com.example.User_management_System.reposetory.RejesterRepo;

@CrossOrigin
@RestController
public class Registration {
	@Autowired
	private RejesterRepo rejesterRepo;
	
	@PostMapping("/register")
	public UserLogin addUser(@RequestBody UserLogin newData)  {
		if(rejesterRepo.findAllByUserName(newData.getUserName()).isEmpty()) {
			return rejesterRepo.save(newData);
		}
		return null;
	}
	
}
