package com.example.User_management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_management_System.model.CMPS;
import com.example.User_management_System.model.Products;
import com.example.User_management_System.model.UserLogin;
import com.example.User_management_System.reposetory.CmpsRepo;
import com.example.User_management_System.reposetory.LoginReop;
import com.example.User_management_System.reposetory.ProductRepo;

@CrossOrigin
@RestController
public class User {
	@Autowired
	private CmpsRepo cmpRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired 
	private LoginReop loginRepo;
	
	
	@GetMapping("/User/ProductView")
	public List<Products> getProduct(){
		return productRepo.findAll();
	}
	
	@GetMapping("{id}/User/getCmps")
	public List<CMPS> getCmps(@PathVariable Long id){
		return cmpRepo.findAllWithNativeUserId(id);
	}
	
	@PostMapping("/{UserId}/User/AddCmp")
	public boolean addCmp(@PathVariable Long UserId,@RequestBody CMPS newCmp) {
		System.out.println(newCmp.getProducts().getId());
		Long productId=newCmp.getProducts().getId();
		List<Products> productOfId=productRepo.findAllById(productId);
		if(!productOfId.isEmpty() && cmpRepo.findAllWithNativeUserandProductId(UserId, productId).isEmpty()) {
			System.out.println("got it");
			cmpRepo.save(newCmp);
			return true;
		}
		else {
			System.out.println("noo");
			return false;
		}
	}
	
	@GetMapping("userDetails/{id}")
	public UserLogin getUserDetilas(@PathVariable Long id) {
		return loginRepo.findAUserById(id);
	}
}
