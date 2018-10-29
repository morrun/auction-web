package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.OperationsHistory;

public interface OperationsHistoryService {
	public List<OperationsHistory> getAllOperationsHistory();
	public void addOperationsHistoryService(OperationsHistory oh);
}
