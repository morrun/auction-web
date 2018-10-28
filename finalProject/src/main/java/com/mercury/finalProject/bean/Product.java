package com.mercury.finalProject.bean;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ecb_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "ECB_PRODUCT_SEQ_GEN", sequenceName = "ECB_PRODUCT_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	@JsonIgnoreProperties("goods")
	private ProductType productType;
	
	@Column
	private int price;
	
	@Column
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date deadline;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductImage> productImages;

	

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductType getProductType() {
		return productType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String title, String description, ProductType productType, int price, Date deadline,
			List<ProductImage> productImages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.productType = productType;
		this.price = price;
		this.deadline = deadline;
		this.productImages = productImages;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	

	
	


}
