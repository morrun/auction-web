package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.dao.ShelvesProductDao;
import com.mercury.finalProject.dao.VisitHistoryDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ShelvesProductService;
import com.mercury.finalProject.serviceHelper.ProductHelper;
@Service
public class ShelvesProductServiceImpl implements ShelvesProductService {

	@Autowired
	private ShelvesProductDao spd;
	@Autowired
	private ProductHelper ph;
	@Override
	public List<ShelvesProduct> getAllShelvesProducts() {
		// TODO Auto-generated method stub
		List<ShelvesProduct> res = spd.findAll();
		return ph.visitHistoryAndShelvesSort(res);
	}
	@Override
	public Response addShelvesProduct(ShelvesProduct p) {
		// TODO Auto-generated method stub
		spd.save(p);
		
		return new Response(true);
	}
	@Override
	public ShelvesProduct getShelvesProductById(int id) {
		// TODO Auto-generated method stub
		return spd.findByProductId(id);
	}
	@Override
	public List<ShelvesProduct> getShelvesProductByUserId(int userId) {
		// TODO Auto-generated method stub
		return spd.findByUserId(userId);
	}
	@Override
	public Response deleteShelvesProduct(ShelvesProduct p) {
		spd.delete(p);
		return new Response(true);
	}

}
