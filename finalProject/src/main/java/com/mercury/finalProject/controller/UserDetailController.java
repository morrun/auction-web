package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.UserDetailService;

@RestController
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/userDetails")
	public List<UserDetail> getAllUserDetail() {
		return userDetailService.getAllUserDetail();
	}
	@PutMapping("/userDetails")
	public Response updateUserDetail(@RequestBody UserDetail ud) {
		UserDetail udn = userDetailService.findByUserId(ud.getUserId());
		if (udn != null)
		ud.setId(udn.getId());
		return userDetailService.updateUserDetail(ud);
	}
	@GetMapping("/userDetails/{id}")
	public UserDetail getUserDetailById(@PathVariable int id) {
		return userDetailService.findByUserId(id);
	}
	@PostMapping("/userDetails")
	public List<UserDetail> getUserDetailByUserIds(@RequestBody List<Integer> ids) {
		return userDetailService.getUserDetailByIdList(ids);
	}
}
