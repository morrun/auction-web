package com.mercury.finalProject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mercury.finalProject.bean.ProductImage;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.ProductImageService;
import com.mercury.finalProject.service.S3Services;

@RestController
public class ProductImageController {

	@Autowired
	private ProductImageService pis;
	@Value("${morrun.aws.link}")
	private String preName;
	@Autowired
	private S3Services s3s;
	@GetMapping("/productImage")
	public List<ProductImage> getAllProductImages() {
		return pis.getAllProductImages();
	}
	@PostMapping("/productImage/{id}")
	public Response addProductImages(@RequestParam("file") MultipartFile file,@PathVariable int id) {
		System.out.println("I am Here********************************************************************");
		String keyName = file.getOriginalFilename();
		String[] arr = keyName.split("\\.");
		String type = arr[arr.length-1];
		String temName = "asdfsdf."+ type;
		ProductImage pi = new ProductImage(temName,id);
		pis.addProductImages(pi);
		List<ProductImage> images = pis.getAllImagesByProductId(id);
		pi = images.get(images.size() - 1);
		int imageId = pi.getId();
		
		String inAwsName = "product" + imageId  + id + "." + type;
		String finalName = preName +  "/" + "product" + imageId  + id + "." + type;
		pi.setImage(finalName);
		pis.addProductImages(pi);
		s3s.uploadFile(inAwsName, file);
		return new Response(true);
	}
	@GetMapping("/productImage/{id}")
	public List<ProductImage> getImagesByProductId(@PathVariable(name = "id") int id) {
		return pis.getAllImagesByProductId(id);
	}
	@PostMapping("/productImage/list")
	public List<ProductImage> getImagesByProductIdList(@RequestBody List<Integer> ids) {
		return pis.getProductImagesByProductList(ids);
	}
}
