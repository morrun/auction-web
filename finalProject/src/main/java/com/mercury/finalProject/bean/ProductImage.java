package com.mercury.finalProject.bean;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ecb_product_image")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_PRODUCT_IMAGE_SEQ_GEN")
	@SequenceGenerator(name = "ECB_PRODUCT_IMAGE_SEQ_GEN", sequenceName = "ECB_PRODUCT_IMAGE_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private String image;
	

	@Column(name = "product_id")
	private int productId;
	public ProductImage() {
		super();
	}

	
	public ProductImage(String image, int productId) {
		super();
		this.image = image;
		this.productId = productId;
	}


	public ProductImage(int id, String image, int productId) {
		super();
		this.id = id;
		this.image = image;
		this.productId = productId;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", image=" + image + ", productId=" + productId + "]";
	}


	
}
