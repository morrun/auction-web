package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.dao.UserDao;
import com.mercury.finalProject.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
}
