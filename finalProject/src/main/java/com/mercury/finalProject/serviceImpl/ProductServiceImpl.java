package com.mercury.finalProject.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.dao.ProductDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	@Override
	public List<Product> getProductsById(List<Integer> ids) {
		List<Product> lp = productDao.findByIdIn(ids);
		List<Product> res = new ArrayList();
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
		// TODO Auto-generated method stub
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
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
//		String deadline = p.getDeadline().getYear() + "/"+p.getDeadline().getMonth() + "/" + p.getDeadline().getDate();
//		try {
//			p.setDeadline(sdf.parse(deadline));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		productDao.save(p);
		
		return productDao.findByTitleAndDescription(p.getTitle(), p.getDescription()).getId();
	}

}
