package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.ProductEnquiryBean;


//@FeignClient(name="fsit-product-stock-service",url="localhost:8800")
@FeignClient(name="fsit-product-stock-service")
public interface ProductStockClient {

	@RequestMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public ProductEnquiryBean checkProductStock(@PathVariable String productName,
			@PathVariable String productAvailability);
}
