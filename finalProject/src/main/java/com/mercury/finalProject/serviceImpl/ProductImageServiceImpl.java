package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.ProductImage;
import com.mercury.finalProject.dao.ProductImageDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductImageService;
@Service
public class ProductImageServiceImpl implements ProductImageService {
	
	@Autowired
	private ProductImageDao pio;
	@Override
	public Response addProductImages(ProductImage images) {
		
		pio.save(images);
		return new Response(true);
	}
	@Override
	public List<ProductImage> getAllProductImages() {
		// TODO Auto-generated method stub
		return pio.findAll();
	}
	@Override
	public List<ProductImage> getAllImagesByProductId(int id) {
		// TODO Auto-generated method stub
		return pio.findByProductId(id);
	}
	@Override
	public List<ProductImage> getProductImagesByProductList(List<Integer> ids) {
		// TODO Auto-generated method stub
		return pio.findByProductIdIn(ids);
	}

}
