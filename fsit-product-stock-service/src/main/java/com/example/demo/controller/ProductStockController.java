package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.ProductStockBean;
import com.example.demo.entity.ProductStock;
import com.example.demo.repo.ProductStockRepository;


@RestController
public class ProductStockController {
	
	@Autowired
	Environment environment;
	@Autowired
	ProductStockRepository productStockRepository;
	
	@RequestMapping("/products")
	public List<ProductStockBean> addProduct() {
		
		List<ProductStockBean> productList=new ArrayList<>();
		
		for(ProductStock ps:productStockRepository.findAll()) {
			ProductStockBean psb=new ProductStockBean(
					ps.getId(), 
					ps.getProductName(), 
					ps.getProductPrice(), 
					ps.getProductAvailability(), 
					ps.getDiscountOffer(), 
					Integer.parseInt(environment.getProperty("local.server.port")));
			productList.add(psb);
		}
		return productList;
		
	}
	
	@RequestMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public Optional<ProductStockBean> searchProduct(@PathVariable String productName,@PathVariable String productAvailability) {
		ProductStock ps=productStockRepository.findByProductNameAndProductAvailability(productName, productAvailability);
		ProductStockBean psb=new ProductStockBean();
		try {
			psb=new ProductStockBean(ps.getId(), ps.getProductName(), ps.getProductPrice(), ps.getProductAvailability(), ps.getDiscountOffer(), 
					Integer.parseInt(environment.getProperty("local.server.port")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	return Optional.ofNullable(psb);
		
	}
	
	

}
