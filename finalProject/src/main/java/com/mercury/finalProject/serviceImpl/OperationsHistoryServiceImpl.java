package com.mercury.finalProject.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Operations;
import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.dao.OperationsDao;
import com.mercury.finalProject.dao.OperationsHistoryDao;
import com.mercury.finalProject.service.OperationsHistoryService;

@Service
public class OperationsHistoryServiceImpl implements OperationsHistoryService {

	@Autowired
	private OperationsHistoryDao ohd;
	@Autowired
	private OperationsDao o;
	@Override
	public List<OperationsHistory> getAllOperationsHistory() {
		return ohd.findAll();
	}
	@Override
	public void addOperationsHistoryService(OperationsHistory oh) {
		oh.setOperationDate(new Date());
		ohd.save(oh);

	}

}
