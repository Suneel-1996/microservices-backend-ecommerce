package com.example.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@ConfigurationProperties(prefix="property-file")
public class PropertyAccessBean {
	
	@Value("${property-file.name}")
	private String property_name;
	
	@Value("${property-file.description}")
	private String property_description;
	
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public String getProperty_description() {
		return property_description;
	}
	public void setProperty_description(String property_description) {
		this.property_description = property_description;
	}
	

}
