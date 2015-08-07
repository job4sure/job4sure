package com.job4sure.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.job4sure.model.UserRegistration;
import com.job4sure.service.RegistrationService;

@Component
public class UserRegistrationValidator implements Validator {

	@Autowired
	private RegistrationService registrationService;

	public boolean supports(Class<?> clazz) {
		return UserRegistration.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "userName",
				"error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "password",
				"error.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.address.empty");

		UserRegistration userRegistration = (UserRegistration) object;

		if (userRegistration.getEmailId() != null
				&& userRegistration.getEmailId().equals("") != true) {
			if (userRegistration.getEmailId().length() > 5) {
				if (userRegistration.getEmailId().contains("@") != true) {
					errors.rejectValue("emailId", "error.emailId.rule");
				} else if (userRegistration.getEmailId().contains(".com") != true
						&& userRegistration.getEmailId().contains(".co.in") != true
						&& userRegistration.getEmailId().contains(".net") != true) {
					errors.rejectValue("emailId", "error.emailId.rule");
				}
			} else {
				errors.rejectValue("emailId", "error.emailId.length");
			}
		}

		if (userRegistration.getUserName() != null
				&& userRegistration.getUserName().equals("") != true) {
			if (userRegistration.getUserName().length() > 5) {
				List<UserRegistration> list = registrationService.findUserByUserName(userRegistration.getUserName());
				if (list != null && list.size() >= 1) {
					errors.rejectValue("userName", "error.userName.rule.exist");
				}
			} else {
				errors.rejectValue("userName", "error.userName.length");
			}
		}
		if (userRegistration.getPassword() != null
				&& userRegistration.getPassword().equals("") != true) {
			if(userRegistration.getPassword().length() < 8){
				errors.rejectValue("password", "error.password.length");
			}
		}

	}
}
