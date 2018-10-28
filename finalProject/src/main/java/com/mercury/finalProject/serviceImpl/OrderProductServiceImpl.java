package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.OrderProduct;
import com.mercury.finalProject.dao.OrderProductDao;
import com.mercury.finalProject.service.OrderProductService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

	@Autowired
	private OrderProductDao orderProductDao;
	@Override
	public List<OrderProduct> getAllOrderProducts() {
		// TODO Auto-generated method stub
		return orderProductDao.findAll();
	}

}
