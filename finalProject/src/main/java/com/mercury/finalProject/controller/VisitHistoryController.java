package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.VisitHistoryService;

@RestController
public class VisitHistoryController {
	@Autowired
	private VisitHistoryService vhs;
	
	@GetMapping("/visitHistory")
	public List<VisitHistory> getAllVisitHistory() {
		return vhs.getAllVisitHistory();
	}
	
	@PostMapping("/visitHistory")
	public Response addVisitHistory(@RequestBody VisitHistory v) {
		return vhs.addVisitHistory(v);
	}
}
