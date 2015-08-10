package com.job4sure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job4sure.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query("select login from Login login where login.userName =:userName")
	public List<Login> findByUserName(@Param("userName") String userName);
}
