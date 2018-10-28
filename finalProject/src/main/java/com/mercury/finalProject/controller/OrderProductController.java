package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.OrderProduct;
import com.mercury.finalProject.service.OrderProductService;

@RestController
public class OrderProductController {

	@Autowired
	private OrderProductService orderProductService;
	
	@GetMapping("/orderProducts")
	public List<OrderProduct> getAllOrderProducts() {
		return orderProductService.getAllOrderProducts();
	}
}
