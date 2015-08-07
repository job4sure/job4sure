package com.job4sure.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.job4sure.model.UserRegistration;
import com.job4sure.repository.RegistrationRepository;
import com.job4sure.service.RegistrationService;
import com.job4sure.util.EncriptionUtil;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Transactional
	 public Integer userRegistration(UserRegistration userRegistration) {
	  String password = EncriptionUtil.encrypted(userRegistration.getPassword());
	  System.out.println(password);
	  userRegistration.setPassword(password);
	  registrationRepository.save(userRegistration);
	  return 1;
	 }

	public List<UserRegistration> findUserByUserName(String UserName) {
		 // registrationRepository;
        //return 1;
		return null;
	}
	}
	
	


