package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.dao.UserDetailDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDao userDetailDao;
	@Override
	public List<UserDetail> getAllUserDetail() {
		// TODO Auto-generated method stub
		return userDetailDao.findAll();
	}
	@Override
	public Response updateUserDetail(UserDetail ud) {
		userDetailDao.save(ud);
		return new Response(true);
	}
	@Override
	public UserDetail findByUserId(int id) {
		
		return userDetailDao.findByUserId(id);
	}

}
