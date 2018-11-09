package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.OperationsHistory;

public interface OperationsHistoryDao extends JpaRepository<OperationsHistory, Integer> {
	List<OperationsHistory> findByProductId(int productId);
}
