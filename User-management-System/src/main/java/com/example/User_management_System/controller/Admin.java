package com.example.User_management_System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.User_management_System.model.Products;
import com.example.User_management_System.model.UserLogin;
import com.example.User_management_System.reposetory.ProductRepo;
import com.example.User_management_System.reposetory.LoginReop;

class ACCES{
	boolean access;

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}
	
}

@CrossOrigin
@RestController
public class Admin {
	@Autowired
	private LoginReop loginReop;

	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("{id}/Admin/products")
	public List<Products> getProducts(){
		return productRepo.findAll();
	}
	
	@PostMapping("{id}/Admin/addProduct")
	public Products addProduct(@RequestBody Products newProduct) {
		return productRepo.save(newProduct);
	}
	
	@PutMapping("{id}/Admin/products/editProsuct/{productId}")
	public Products editproduct(@PathVariable Long productId,@RequestBody Products updateProduct ) {
		Optional<Products> update=productRepo.findById(productId);
		if(update.isPresent()) {
			 Products toUpdateproduct = update.get();
			 toUpdateproduct.setProduct(updateProduct.getProduct());
			 toUpdateproduct.setSubType(updateProduct.getSubType());
			 toUpdateproduct.setType(updateProduct.getType());
			 return productRepo.save(toUpdateproduct);
		 }
		return null;
	}
	
	@GetMapping("/Admin/ViewUser")
	public List<UserLogin> getUser(){
		return loginReop.findAll();
	}
	
	@PutMapping("/Admin/setStatus/{userID}")
	public void setStatus(@PathVariable Long userID,@RequestBody ACCES ACCESS1 ) {
		boolean ACCESS=ACCESS1.isAccess();
		System.out.println(ACCESS);
		 Optional<UserLogin> userOpt = loginReop.findById(userID);
		 if(userOpt.isPresent()) {
			 UserLogin user = userOpt.get();
			 user.setAccess(ACCESS);
			 loginReop.save(user);
		 }
	}
	
	@DeleteMapping("Admin/Delete/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		
		productRepo.deleteById(productId);
	}
	
}
