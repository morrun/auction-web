package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.OperationView;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.OperationViewService;

@RestController
@RequestMapping("/operationViews")
public class OperationViewController {
	@Autowired
	private OperationViewService ovs;
	
	@GetMapping("/buyer/{id}")
	public List<OperationView> getByBuyerUserId(@PathVariable(name = "id") int buyerUserId) {
		return ovs.getByBuyerUserId(buyerUserId);
	}
	@GetMapping("/seller/{id}")
	public List<OperationView> getBySellerUserId(@PathVariable(name = "id") int sellerUserId) {
		return ovs.getBySellerUserId(sellerUserId);
	}
	@PostMapping
	public Response addOperationView(@RequestBody OperationView ov) {
		return ovs.addOperationView(ov);
	}
	@PutMapping("/seller")
	public Response updateOperationView(@RequestBody OperationView ov) {
		return ovs.updateOperationView(ov);
	}
}
