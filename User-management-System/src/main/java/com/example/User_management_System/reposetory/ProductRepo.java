package com.example.User_management_System.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.User_management_System.model.Products;
import com.example.User_management_System.model.UserLogin;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{
//	@Query("Select * from products where id= :productId")
	List<Products> findAllById(Long productId);
	
	Optional<Products> findById(Long id);
}
