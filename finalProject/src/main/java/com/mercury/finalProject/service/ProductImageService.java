package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.ProductImage;
import com.mercury.finalProject.http.Response;

public interface ProductImageService {
	public Response addProductImages(ProductImage images);
	public List<ProductImage> getAllProductImages();
	public List<ProductImage> getAllImagesByProductId(int id);
	public List<ProductImage> getProductImagesByProductList(List<Integer> ids);
}
