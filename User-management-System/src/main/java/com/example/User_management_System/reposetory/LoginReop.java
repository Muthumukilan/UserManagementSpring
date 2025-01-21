package com.example.User_management_System.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.User_management_System.model.UserLogin;

@Repository
public interface LoginReop extends JpaRepository<UserLogin, String> { 
    
	@Query("SELECT u.id FROM UserLogin u WHERE u.userName = :userName and u.password=:password")
    Long findByUserNameAndPassword(String userName,String password);
    
    @Query("SELECT u.id FROM UserLogin u WHERE u.userName = :userName")
    Long findIdByUserName(String userName);
    
    @Query("SELECT u.role FROM UserLogin u WHERE u.id = :id")
    String findRoleById(Long id);
    
    @Query("SELECT u.access FROM UserLogin u WHERE u.id = :id")
    boolean findAccessById(Long id);
    
    @Query(value = "SELECT * from user_Login where id = :id",nativeQuery = true)
    UserLogin findAUserById(Long id);
    
    Optional<UserLogin> findById(Long id);
}
