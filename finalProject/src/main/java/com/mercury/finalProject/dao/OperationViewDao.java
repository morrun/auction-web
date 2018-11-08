package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.OperationView;

public interface OperationViewDao extends JpaRepository<OperationView, Integer> {
	List<OperationView> findBySellerUserId(int sellerUsreId);
	List<OperationView> findByBuyerUserId(int buyerUserId);
	OperationView findByBuyerUserIdAndProductId(int buyerUserId, int productId);
}
