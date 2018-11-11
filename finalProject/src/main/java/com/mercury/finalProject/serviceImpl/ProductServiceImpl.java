package com.mercury.finalProject.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.dao.ProductDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.serviceHelper.ProductHelper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductHelper ph;
	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	@Override
	public List<Product> getProductsById(List<Integer> ids) {
		List<Product> lp = productDao.findByIdIn(ids);
		List<Product> res = new ArrayList<Product>();
		for (Integer i: ids) {
			for (Product p: lp) {
				if (p.getId() == i) {
					res.add(p);									
					break;
				}
			}
		}
		return res;
	}
	@Override
	public Response addProduct(Product p) {
		
		productDao.save(p);
		return new Response(true);
	}
	@Override
	public List<Product> getProductsByTypeId(int id) {
		// TODO Auto-generated method stub
		return productDao.findByProductTypeId(id);
	}
	@Override
	public Product getByProductId(int id) {
		return productDao.findById(id);
	}
	@Override
	public int addProductAndGetId(Product p) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 12);
		p.setDeadline(c.getTime());
		productDao.save(p);
		return productDao.findByTitleAndDescription(p.getTitle(), p.getDescription()).getId();
	}
	@Override
	public Response updateProduct(int id, Product p) {
		Product tmp = productDao.findById(id);
		if (p.getDescription() != null && p.getDescription().length() != 0)
		tmp.setDescription(p.getDescription());
		if (p.getPrice() > 0)
		tmp.setPrice(p.getPrice());
		if (p.getProductTypeId() > 0)
		tmp.setProductTypeId(p.getProductTypeId());
		if (p.getDeadline() != null)
		tmp.setDeadline(p.getDeadline());
		if (p.getTitle() != null && p.getTitle().length() != 0)
		tmp.setTitle(p.getTitle());
		productDao.save(tmp);
		return new Response(true);
	}

}
