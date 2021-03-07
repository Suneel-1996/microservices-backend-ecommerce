package com.cart.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.entity.CategoryEntity;
import com.cart.demo.entity.ProductEntity;
import com.cart.demo.repo.CategoryRepo;
import com.cart.demo.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductContoller {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	
	
	@RequestMapping("/get-all-products")
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> productList= new ArrayList<ProductEntity>();
		try {
			productList=productRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productList;
	}
	
	@RequestMapping("/get-product-by-category-id/{categoryId}")
	public List<ProductEntity> getProductsByCategory(@PathVariable String categoryId) {
		List<ProductEntity> productList= new ArrayList<ProductEntity>();
		try {
			productList= productRepo.findByCategoryId(categoryId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productList;
	}
	
	@RequestMapping("/get-all-category")
	public List<CategoryEntity> getAllCategory(){
		List<CategoryEntity> categoryList= new ArrayList<CategoryEntity>();
		try {
			categoryList=categoryRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return categoryList;
	}
	
	@RequestMapping("/get-product-by-id/{productId}")
	public ProductEntity getProductById(@PathVariable long productId) {
		ProductEntity product= new ProductEntity();
		try {
			product = productRepo.findById(productId).get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return product;
	}
	
}
