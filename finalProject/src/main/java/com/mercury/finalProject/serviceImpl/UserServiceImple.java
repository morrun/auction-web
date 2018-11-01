package com.mercury.finalProject.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.bean.UserProfile;
import com.mercury.finalProject.dao.UserDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.security.SecurityUtils;
import com.mercury.finalProject.service.UserService;

@Service
@Transactional
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	PasswordEncoder pe;
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	public Response register(User user) {
		try {
			System.out.println(user);
			user.setPassword(pe.encode(user.getPassword()));
			List<UserProfile> profiles = new ArrayList<UserProfile>();
			profiles.add(new UserProfile(2));
			user.setProfiles(profiles);
			user.setRegisteredDate(new Date());
			userDao.save(user);
			// TODO: send email. assume username is the email for now
			//emailService.sendSimpleMessage(user.getUsername(), "Account Created", user.getUsername() + ", your account is created!");
			return new Response(true);
		} catch (Exception e) {
			//LOGGER.error(e.getMessage());
			return new Response(false, 400, e.getMessage());
		}
	}

	@Override
	public Response changePassword(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName()) || SecurityUtils.isAdmin(authentication.getAuthorities())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setPassword(pe.encode(user.getPassword()));
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}

	@Override
	public Response deleteUser(int id) {
		if(userDao.findById(id).getUsername() != null && userDao.findById(id).getId() == id) {
			userDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}

	@Override
	public Response updateUser(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setImage(user.getImage());
			u.getUserDetail().setAddress1(user.getUserDetail().getAddress1());
			u.getUserDetail().setAddress2(user.getUserDetail().getAddress2());
			u.getUserDetail().setName(user.getUserDetail().getName());
			u.getUserDetail().setPhone(user.getUserDetail().getPhone());
			u.getUserDetail().setCity(user.getUserDetail().getCity());
			u.getUserDetail().setEmail(user.getUsername());
			u.getUserDetail().setState(user.getUserDetail().getState());
			u.getUserDetail().setZip(user.getUserDetail().getZip());
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}

	
}
