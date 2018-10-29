package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.dao.ShelvesProductDao;
import com.mercury.finalProject.http.Response;
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
	@Override
	public Response addShelvesProduct(ShelvesProduct p) {
		// TODO Auto-generated method stub
		spd.save(p);
		return new Response(true);
	}

}
