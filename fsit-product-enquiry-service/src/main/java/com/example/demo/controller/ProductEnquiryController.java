package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.ProductEnquiryBean;
import com.example.demo.client.ProductStockClient;

@RestController
public class ProductEnquiryController {
	
	@Autowired
	ProductStockClient client;
	
	@RequestMapping("/product-enquiry/name/{name}/availability/{availability}/unit/{unit}")
	public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name,@PathVariable String availability, @PathVariable int unit) {
		ProductEnquiryBean peb= new ProductEnquiryBean();
		
		try {
			peb=client.checkProductStock(name, availability);
			double totalPrice=peb.getProductPrice().doubleValue()*unit;
			System.out.println(totalPrice);
			System.err.println(peb.getDiscountOffer());
			double discountPrice=totalPrice-(peb.getDiscountOffer()*totalPrice/100);
			peb=new ProductEnquiryBean(
					peb.getId(), 
					name, 
					peb.getProductPrice(), 
					availability, 
					peb.getDiscountOffer(), 
					unit, 
					discountPrice, 
					peb.getPort());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return peb;
		
	}
	

}
