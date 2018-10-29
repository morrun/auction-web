package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.service.OperationsHistoryService;

@RestController
public class OperationsHistoryController {

	@Autowired
	private OperationsHistoryService ohs;
	
	@GetMapping("/operationsHistory")
	public List<OperationsHistory> getAllOperationsHistory() {
		return ohs.getAllOperationsHistory();
	}
}
