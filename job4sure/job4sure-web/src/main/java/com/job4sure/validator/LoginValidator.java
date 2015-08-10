package com.job4sure.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.job4sure.model.Login;

@Component
@Qualifier("LoginValidator")
public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Login.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "userName",
				"error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "password",
				"error.password.empty");
		Login login = (Login) object;
		if (login.getUserName() != null
				&& login.getUserName().equals("") != true) {
			if (login.getUserName().length() < 8
					|| login.getUserName().length() > 32) {
				errors.rejectValue("userName", "error.userName.length");
			}
		}
		if (login.getPassword() != null
				&& login.getPassword().equals("") != true) {
			if (login.getPassword().length() < 8
					|| login.getPassword().length() > 16) {
				errors.rejectValue("password", "error.password.length");
			}
		}
	}

}
