package com.mercury.finalProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.serviceImpl.UserServiceImple;

@RestController
public class UserController {
	@Autowired
	private UserServiceImple userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/users")	
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") int id){
		return userService.getUserById(id);
	}
	
	@PostMapping("/users")
	public Response addUser(@Valid @RequestBody User user) {
		return userService.register(user);
	}
	@PutMapping("/users/{id}")
	public Response updateUser(@Valid @RequestBody User user, Authentication authentication) {
		return userService.updateUser(user, authentication);
	}
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PutMapping
	public Response changeUser(@RequestBody User user, Authentication authentication) {
		return userService.changePassword(user, authentication);
	}
	
	@DeleteMapping("/users/{id}")
	public Response deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PostMapping("/users/{id}")
	public boolean CheckPassword(@RequestBody String password, @PathVariable int id) {
		User user = userService.getUserById(id);
		String pw = passwordEncoder.encode(password);
		if (!pw.equals(user.getPassword())) return false;
		return true;
	}
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PostMapping("/users/changePassword/{id}")
	public Response ChangePassword(@RequestBody String password, @PathVariable int id, Authentication authentication) {
		User user = userService.getUserById(id);
		user.setPassword(password);
		return userService.changePassword(user,authentication);
	}
}
