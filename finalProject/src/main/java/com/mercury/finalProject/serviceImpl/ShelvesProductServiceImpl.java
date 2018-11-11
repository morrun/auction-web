package com.mercury.finalProject.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.bean.VisitHistory;
import com.mercury.finalProject.dao.ProductDao;
import com.mercury.finalProject.dao.ShelvesProductDao;
import com.mercury.finalProject.dao.VisitHistoryDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.service.ShelvesProductService;
import com.mercury.finalProject.serviceHelper.ProductHelper;
@Service
public class ShelvesProductServiceImpl implements ShelvesProductService {

	@Autowired
	private ProductDao pd;
	@Autowired
	private ShelvesProductDao spd;
	@Autowired
	private ProductHelper ph;
	@Autowired
	private ProductService ps;
	@Override
	public List<ShelvesProduct> getAllShelvesProducts() {
		// TODO Auto-generated method stub
		List<ShelvesProduct> res = spd.findAll();
		return ph.visitHistoryAndShelvesSort(res);
	}
	@Override
	public Response addShelvesProduct(ShelvesProduct p) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 12);
		spd.save(p);
		Product product = pd.findById(p.getProductId());
		
		product.setDeadline(c.getTime());
		pd.save(product);
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
	@Override
	public long getRemainTime(int productId) {
		Product p = ps.getByProductId(productId);
		long diffInMillies = Math.abs(p.getDeadline().getTime() - (new Date()).getTime());
	    long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    if (diff < 0) diff = 0;
		return diff;
	}

}
