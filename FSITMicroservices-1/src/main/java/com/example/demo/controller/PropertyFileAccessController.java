package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beans.PropertyAccessBean;
import com.example.demo.beans.PropertyAccessValue;
@RefreshScope
@RestController
@RequestMapping("/access")
public class PropertyFileAccessController {
	@Autowired
	PropertyAccessBean propertyAccessBean;
	
	
	
	
	@RequestMapping("accessPropertyFile")
	public PropertyAccessValue accessPropertyFile() {
		
		//refreshActuator();
		return new PropertyAccessValue(propertyAccessBean.getProperty_name(),
				propertyAccessBean.getProperty_description());
		
	}
	
	public void refreshActuator() {
		RestTemplate restTemplate= new RestTemplate();
		final String baseUrl="http://localhost:8100/actuator/refresh";
		HttpHeaders headers= new HttpHeaders();
		headers.set("Content-type", "application/json");
		HttpEntity entity= new HttpEntity(headers);
		ResponseEntity<String> results=restTemplate.postForEntity(baseUrl, entity, String.class);
	}

}
