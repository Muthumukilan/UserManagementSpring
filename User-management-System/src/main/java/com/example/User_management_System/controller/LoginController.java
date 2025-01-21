package com.example.User_management_System.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.User_management_System.reposetory.LoginReop;

class Role{
	public String role;
}

class Access{
	public boolean acces;
}

@RestController
@CrossOrigin
public class LoginController {
	
    @Autowired
    private LoginReop loginRepo;
    
    @GetMapping("/login/{userName}/{password}")
    public long getUserByUserNameandPass(@PathVariable String userName,@PathVariable String password) {
    	if(loginRepo.findByUserNameAndPassword(userName,password)!=null)
    		return loginRepo.findByUserNameAndPassword(userName,password);  
    	return -1;// Fetch user by userName
    }
    
    @GetMapping("/login/{id}")
    public Role getRole(@PathVariable Long id) {
    	Role r = new Role();
    	r.role=loginRepo.findRoleById(id);
    	return r;
    }
    @GetMapping("/login/access/{id}")
    public Access getaccess(@PathVariable Long id) {
    	Access a = new Access();
    	a.acces=loginRepo.findAccessById(id);
    	return a;
    }
}
