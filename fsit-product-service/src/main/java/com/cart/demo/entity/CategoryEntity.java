package com.cart.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
	
	@Id
	private long id;
	private String name;
	
	
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryEntity(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
