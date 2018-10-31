package com.mercury.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.AuthService;

@RestController
public class AuthController {
	@Autowired
	AuthService authService;
	
	@GetMapping("/checkLogin")
	public Response checklogin(Authentication authentication) {
		return authService.checklogin(authentication);
	}

}
