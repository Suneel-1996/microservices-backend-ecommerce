package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
import com.example.demo.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/get-all-products")
	public List<ProductModel> getProducts() {
		ProductModel product= new ProductModel();
		List<ProductModel> productList= new ArrayList<ProductModel>();
		try {
			productList=productRepository.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productList;
		
	}
	
	@RequestMapping("/get-product-by-id/{productId}")
	public Optional<ProductModel> getProductById(@PathVariable(value="productId") Long productId) {
		Optional<ProductModel> product= Optional.empty();
		try {
			
			product=productRepository.findById(productId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return product;
				
	}
	
	@RequestMapping("/get-product-by-name/{productName}")
	public List<ProductModel> getProductsByName(@RequestParam String productName){
		
		List<ProductModel> productList= new ArrayList<ProductModel>();
		try {
			productList=productRepository.findAllByProductName(productName);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productList;
		
	}
	
	@PostMapping("/add-product")
	@ResponseBody
	public ProductModel addProduct(@RequestBody ProductModel product) {
		productRepository.save(product);
		
		return product;
		
	}
	

}
