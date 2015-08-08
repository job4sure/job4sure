package com.job4sure.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4sure.model.UserRegistration;

public interface RegistrationRepository extends JpaRepository<UserRegistration, Integer> {
	
	 @Query("select userRegistration from UserRegistration userRegistration where userRegistration.userName =:userName")
	 public List<UserRegistration> findByUserName(
	   @Param("userName") String userName);
	 
	}


