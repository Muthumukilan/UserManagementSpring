package com.example.User_management_System.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.User_management_System.model.UserLogin;

@Repository
public interface RejesterRepo extends JpaRepository<UserLogin, Long>{
	
	@Query(value = "select * from User_login where user_name = :username",nativeQuery = true)
	List<UserLogin> findAllByUserName(@Param("username") String username);
	
}
