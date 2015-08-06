package com.job4sure.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.job4sure.model.UserRegistration;
import com.job4sure.repository.RegistrationRepository;
import com.job4sure.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Transactional
	public Integer userRegistration(UserRegistration userRegistration) {
		registrationRepository.save(userRegistration);
		return 1;
	}
	
	/*@Transactional
    public Integer userRegistration(UserRegistration userRegistration) {
		registrationRepository.save(userRegistration) ;
		return 1;
    }

    public List<UserRegistration> getAllUser()
    {
    	
        List<UserRegistration> userRegistration = registrationRepository.findAll();
        return userRegistration;
    }*/

}
