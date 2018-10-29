package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.dao.ShelvesProductDao;
import com.mercury.finalProject.service.ShelvesProductService;
@Service
public class ShelvesProductServiceImpl implements ShelvesProductService {

	@Autowired
	private ShelvesProductDao spd;
	@Override
	public List<ShelvesProduct> getAllShelvesProducts() {
		// TODO Auto-generated method stub
		return spd.findAll();
	}

}
