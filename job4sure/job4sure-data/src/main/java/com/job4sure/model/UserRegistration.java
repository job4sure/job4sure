package com.job4sure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_REGISTRATION_ID")
	private Integer userRegistrationId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	/*
	 * @OneToOne(fetch = FetchType.LAZY, mappedBy = "login", cascade =
	 * CascadeType.ALL) private Login login;
	 */

	/*
	 * public Login getLogin() { return login; }
	 * 
	 * public void setLogin(Login login) { this.login = login; }
	 */
	@Column(name = "ADDRESS")
	private String address;

	public Integer getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Integer userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
