package com.munna.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.munna.entity.Faculty;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<Faculty, Integer> {

	@Transactional
	@Modifying
	@Query("update  Faculty set salary =:sal where id =:id")
	int upFacById(@Param("sal") Double sal, @Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from  Faculty  where id =:id")
	int upDelById(@Param("id") Integer id);
	
	
	
	
	
  
}
