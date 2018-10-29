package com.mercury.finalProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ShelvesProductService;

@RestController
public class ShelvesProductController {

	@Autowired
	private ShelvesProductService sps;
	
	@GetMapping("/shelvesProducts")
	public List<ShelvesProduct> getAllShelvesProducts() {
		return sps.getAllShelvesProducts();
	}
	@PostMapping("/shelvesProducts")
	public Response addShelvesProducts(@RequestBody ShelvesProduct p) {
		p.getShelves().setOnShelvesDate(new Date());
		return sps.addShelvesProduct(p);
	}
}
