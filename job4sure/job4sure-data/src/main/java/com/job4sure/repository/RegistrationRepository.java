package com.job4sure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job4sure.model.UserRegistration;

public interface RegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
