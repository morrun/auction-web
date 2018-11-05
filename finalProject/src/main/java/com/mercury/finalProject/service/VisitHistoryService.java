package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.http.Response;

public interface VisitHistoryService {
	public List<VisitHistory> getAllVisitHistory();
	public Response addVisitHistory(VisitHistory v);
}
