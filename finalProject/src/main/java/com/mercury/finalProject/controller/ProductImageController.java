package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.ProductImage;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductImageService;

@RestController
public class ProductImageController {

	@Autowired
	private ProductImageService pis;
	@GetMapping("/productImage")
	public List<ProductImage> getAllProductImages() {
		return pis.getAllProductImages();
	}
	@PostMapping("/productImage")
	public Response addProductImages(@RequestBody List<ProductImage> images) {
		return pis.addProductImages(images);
	}
	@GetMapping("/productImage/{id}")
	public List<ProductImage> getImagesByProductId(@PathVariable(name = "id") int id) {
		return pis.getAllImagesByProductId(id);
	}
}
