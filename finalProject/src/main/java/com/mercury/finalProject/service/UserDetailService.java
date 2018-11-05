package com.mercury.finalProject.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.http.Response;

public interface UserDetailService {
	public List<UserDetail> getAllUserDetail();
	public Response updateUserDetail(UserDetail ud);
	public UserDetail findByUserId(int id);
	public Response saveUserHeadIcon(MultipartFile file,int id);
}
