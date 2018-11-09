package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.http.Response;

public interface OperationsHistoryService {
	public List<OperationsHistory> getAllOperationsHistory();
	public void addOperationsHistoryService(OperationsHistory oh);
	public List<OperationsHistory> getAllOperationsHistroyByProductId(int productId);
	public Response deleteByProductId(int productId);
}
