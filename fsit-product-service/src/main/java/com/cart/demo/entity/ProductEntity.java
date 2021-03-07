package com.cart.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductEntity {
	
	@Id
	private long id;
	private String name,price,addedOn,categoryId,imageUrl;
	
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductEntity(long id, String name, String price, String addedOn, String categoryId,String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.addedOn = addedOn;
		this.categoryId = categoryId;
		this.imageUrl=imageUrl;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	

}
