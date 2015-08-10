package com.job4sure.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job4sure.model.Login;
import com.job4sure.repository.LoginRepository;
import com.job4sure.service.LoginService;
import com.job4sure.util.EncriptionUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public Login checkSigIn(Login login) {
		List<Login> loginList = loginRepository.findByUserName(login
				.getUserName());
		if (loginList != null && loginList.size() == 1) {
			Login tempLogin = loginList.get(0);
			String password = tempLogin.getPassword();
			password = EncriptionUtil.encrypted(password);
			if (login.getPassword().equals(password)) {
				return tempLogin;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
