package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.OperationsHistory;

public interface OperationsHistoryDao extends JpaRepository<OperationsHistory, Integer> {

}
