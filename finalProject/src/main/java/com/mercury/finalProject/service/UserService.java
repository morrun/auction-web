package com.mercury.finalProject.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.http.Response;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public Response register(User user);
	public Response changePassword(User user, Authentication authentication);
	public Response deleteUser(int id);
}
