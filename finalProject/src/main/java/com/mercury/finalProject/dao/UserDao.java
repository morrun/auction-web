package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	User findById(int id);
}
