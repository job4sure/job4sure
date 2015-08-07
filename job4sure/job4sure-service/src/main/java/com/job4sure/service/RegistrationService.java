package com.job4sure.service;

import java.util.List;

import com.job4sure.model.UserRegistration;

public interface RegistrationService {
	public Integer userRegistration(UserRegistration userRegistration);
	
	public List<UserRegistration> findUserByUserName(String UserName);
}
