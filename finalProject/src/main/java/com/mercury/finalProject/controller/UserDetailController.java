package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.service.UserDetailService;

@RestController
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/userDetails")
	public List<UserDetail> getAllUserDetail() {
		return userDetailService.getAllUserDetail();
	}
}
