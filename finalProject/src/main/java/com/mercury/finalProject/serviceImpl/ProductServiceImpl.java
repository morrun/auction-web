package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.dao.ProductDao;
import com.mercury.finalProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		System.out.println("************************************");
		return productDao.findAll();
	}

}
