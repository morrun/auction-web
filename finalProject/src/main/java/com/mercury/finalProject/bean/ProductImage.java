package com.mercury.finalProject.bean;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ecb_product_image")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_PRODUCT_IMAGE_SEQ_GEN")
	@SequenceGenerator(name = "ECB_PRODUCT_IMAGE_SEQ_GEN", sequenceName = "ECB_PRODUCT_IMAGE_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private Blob image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore //Properties("productImages")
	private Product product;
	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public ProductImage(int id, Blob image, Product product) {
		super();
		this.id = id;
		this.image = image;
		this.product = product;
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
		return "ProductImage [id=" + id + ", image=" + image + ", product=" + product + "]";
	}


	
}
