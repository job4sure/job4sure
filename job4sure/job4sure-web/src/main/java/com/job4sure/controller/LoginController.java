package com.job4sure.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job4sure.model.Login;
import com.job4sure.serviceImpl.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@Autowired
	@Qualifier("LoginValidator")
	private Validator validator;

	@RequestMapping(value = "home", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String home() {
		return "home";
	}

	@RequestMapping(value = "signIn", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String signIn(HttpServletRequest request, Map<String, Object> map,
			@ModelAttribute Login login, BindingResult bindingResult,
			Model model) {

		String methodType = request.getMethod();

		if (methodType.equals("POST")) {
			validator.validate(login, bindingResult);
			if (!bindingResult.hasErrors()) {
				login = loginService.checkSigIn(login);
				if (login != null) {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("user", login);
					return "home";
				} else {
					model.addAttribute("invalid",
							"username and password is invalid.");
					return "login";
				}
			} else {
				return "login";
			}

		} else {
			map.put("login", new Login());
			return "login";
		}
	}
}
