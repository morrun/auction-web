package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.ProductType;
import com.mercury.finalProject.dao.ProductTypeDao;
import com.mercury.finalProject.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;
	@Override
	public List<ProductType> getAllProductTypes() {
		// TODO Auto-generated method stub
		return productTypeDao.findAll();
	}

}
