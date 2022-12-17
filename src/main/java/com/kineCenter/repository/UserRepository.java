package com.kineCenter.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.kineCenter.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	@Query("select u from User u where u.username != 'adminadmin'")
	List<User> ListeUsers2();
	
	/*@Modifying
	@Query("update User u set u.enabled = :ee where u.user_id = :id")
	void ActDesact(@Param(value = "id") long id, @Param(value = "ee") boolean ee);*/
	
	

}
