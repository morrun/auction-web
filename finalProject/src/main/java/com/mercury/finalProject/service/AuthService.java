package com.mercury.finalProject.service;

import org.springframework.security.core.Authentication;

import com.mercury.finalProject.http.Response;

public interface AuthService {
	public Response checklogin(Authentication authentication);
}
