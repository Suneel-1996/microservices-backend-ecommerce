package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name = "products")
public class ProductModel {
	
	@Id
	private long id;
	
	
	@Basic(optional = false)
	@Column(name = "product_name")
	private String productName;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_image_url")
	private String productImageUrl;
	
	
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(long id, String productName, String productDescription,double productPrice, String productImageUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription=productDescription;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	

}
