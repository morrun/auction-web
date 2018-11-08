package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.UserDetail;

public interface UserDetailDao extends JpaRepository<UserDetail, Integer> {
	UserDetail findByUserId(int id);
	List<UserDetail> findByUserIdIn(List<Integer> ids);
}
