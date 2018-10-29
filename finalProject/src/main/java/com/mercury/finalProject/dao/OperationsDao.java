package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.Operations;

public interface OperationsDao extends JpaRepository<Operations, Integer> {

}
