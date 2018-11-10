package com.mercury.finalProject.service;

import javax.servlet.http.HttpSessionListener;

import org.springframework.security.core.Authentication;

import com.mercury.finalProject.http.Response;

public interface AuthService extends HttpSessionListener{
	public Response checklogin(Authentication authentication);
	public int getActiveSessionNumber();
}
