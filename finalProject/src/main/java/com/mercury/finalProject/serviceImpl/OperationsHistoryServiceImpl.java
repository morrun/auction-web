package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.dao.OperationsHistoryDao;
import com.mercury.finalProject.service.OperationsHistoryService;

@Service
public class OperationsHistoryServiceImpl implements OperationsHistoryService {

	@Autowired
	private OperationsHistoryDao ohd;
	@Override
	public List<OperationsHistory> getAllOperationsHistory() {
		// TODO Auto-generated method stub
		return ohd.findAll();
	}

}
