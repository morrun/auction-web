package com.mercury.finalProject.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercury.finalProject.serviceImpl.ProductServiceImpl;

public class ProductServiceTest {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Test
	public void test() {
		productServiceImpl.getProducts();
	}

}
