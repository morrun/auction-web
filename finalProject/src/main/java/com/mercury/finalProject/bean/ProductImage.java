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
	private Blob image;
	
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "product_id")
//	@JsonIgnoreProperties("productImages")
//	private Product product;
	@Column(name = "product_id")
	private int productId;
	public ProductImage() {
		super();
	}




	public ProductImage(int id, Blob image) {
		super();
		this.id = id;
		this.image = image;
	}


	public ProductImage(int id, Blob image, int productId) {
		super();
		this.id = id;
		this.image = image;
		this.productId = productId;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", image=" + image + ", productId=" + productId + "]";
	}


	
}
