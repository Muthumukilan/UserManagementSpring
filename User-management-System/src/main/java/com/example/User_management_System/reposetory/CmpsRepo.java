package com.example.User_management_System.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.User_management_System.model.CMPS;

@Repository
public interface CmpsRepo extends JpaRepository<CMPS, Long>{
	
	Optional<CMPS> findByOrderId(Long id);
	
	@Query(value="select * from cmps c join user_login l on c.user_id = l.id where c.user_id = :userId", nativeQuery = true)
	List<CMPS> findAllWithNativeUserId(@Param("userId") Long userId);
	
	@Query(value="select * from cmps c join user_login l on c.user_id = l.id   where c.user_id = :userId and c.product_id = :productId", nativeQuery = true)
	List<CMPS> findAllWithNativeUserandProductId(@Param("userId") Long userId,@Param("productId")Long productId);
}
