package com.job4sure.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job4sure.model.UserRegistration;
import com.job4sure.service.RegistrationService;
import com.job4sure.validator.UserRegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private UserRegistrationValidator validator;

	@RequestMapping(value = "/userRegistrationPage", method = RequestMethod.GET)
	public String registrationPage(Map<String, Object> map) {
		map.put("userRegistration", new UserRegistration());
		return "userRegistration";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute UserRegistration userRegistration, BindingResult bindingResult,
			Model model) {
		validator.validate(userRegistration, bindingResult);
		if (bindingResult.hasErrors()) {
			return "userRegistration";
		} else {
			Integer id = registrationService.userRegistration(userRegistration);
			if (id != null) {
				model.addAttribute("registrationMessage", "You registration successfully done.");
			} else {
				model.addAttribute("registrationMessage", "You registration failed..");
			}
		}

		return "userRegistration";
	}
}
