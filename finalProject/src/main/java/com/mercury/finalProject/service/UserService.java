package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(int id);
}
