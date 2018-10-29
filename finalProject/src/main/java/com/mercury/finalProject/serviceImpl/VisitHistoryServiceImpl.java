package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.dao.VisitHistoryDao;
import com.mercury.finalProject.service.VisitHistoryService;

@Service
public class VisitHistoryServiceImpl implements VisitHistoryService {
	
	@Autowired
	private VisitHistoryDao vhd;
	@Override
	public List<VisitHistory> getAllVisitHistory() {
		
		return vhd.findAll();
	}

}
