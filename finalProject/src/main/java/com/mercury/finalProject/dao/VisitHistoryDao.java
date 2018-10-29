package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.VisitHistory;

public interface VisitHistoryDao extends JpaRepository<VisitHistory, Integer> {

}
