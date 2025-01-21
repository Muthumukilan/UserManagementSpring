package com.example.User_management_System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_management_System.model.CMPS;
import com.example.User_management_System.reposetory.CmpsRepo;

class State{
	String status;

	public String getStatus() {
		return status;
	}
}

@CrossOrigin
@RestController
public class Manager {
	
	@Autowired
	private CmpsRepo cmpRepo;
	
	@GetMapping("/statusView")
	public List<CMPS> viewStatus(){
		return cmpRepo.findAll();
	}
	
	@PutMapping("/statusUpdate/{id}")
	public void statusUpdate(@PathVariable Long id,@RequestBody State Status) {
		String newStatus = Status.getStatus();
		Optional<CMPS> cmps = cmpRepo.findByOrderId(id);
		if(cmps.isPresent()) {
			CMPS cmp=cmps.get();
			cmp.setStatus(newStatus);
			cmpRepo.save(cmp);
		}
	}
	
}
