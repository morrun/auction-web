package com.mercury.finalProject.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.OperationView;
import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.dao.OperationViewDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.OperationViewService;
import com.mercury.finalProject.service.ProductService;

@Service
public class OperationViewServiceImpl implements OperationViewService {
	@Autowired
	private OperationViewDao ovd;
	
	@Override
	public List<OperationView> getBySellerUserId(int sellerUserId) {
		// TODO Auto-generated method stub
		return ovd.findBySellerUserId(sellerUserId);
	}

	@Override
	public List<OperationView> getByBuyerUserId(int buyerUserId) {
		// TODO Auto-generated method stub
		return ovd.findByBuyerUserId(buyerUserId);
	}

	@Override
	public Response addOperationView(OperationView ov) {
		// TODO Auto-generated method stub
		ovd.save(ov);
		return new Response(true);
	}

	@Override
	public Response updateOperationView(OperationView ov) {
		ovd.save(ov);
		return new Response(true);
	}

	@Override
	public Response deleteByProductId(int productId) {
		ovd.deleteByProductId(productId);
		return new Response(true);
	}

	@Override
	public List<OperationView> getByProductId(int productId) {
		// TODO Auto-generated method stub
		return ovd.findByProductId(productId);
	}

}
