package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.OperationsHistoryService;

@RestController
@Transactional
public class OperationsHistoryController {

	@Autowired
	private OperationsHistoryService ohs;
	
	@GetMapping("/operationsHistory")
	public List<OperationsHistory> getAllOperationsHistory() {
		return ohs.getAllOperationsHistory();
	}
	@GetMapping("/operationsHistory/{id}")
	public List<OperationsHistory> getAllOperationHistory(@PathVariable int id) {
		return ohs.getAllOperationsHistroyByProductId(id);
	}
	@PostMapping("/operationsHistory")
	public void addOperationHistory(@RequestBody OperationsHistory oh) {
		//System.out.println(oh);
		ohs.addOperationsHistoryService(oh);
	}
	@DeleteMapping("/operationsHistory/{id}")
	public Response deleteByProductId(@PathVariable("id") int productId) {
		System.out.println("******************************" + productId);
		return ohs.deleteByProductId(productId);
	}
}
