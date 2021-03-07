package com.example.demo.beans;

public class PropertyAccessValue {
	private String property_name;
	private String property_description;
	
	public PropertyAccessValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAccessValue(String property_name, String property_description) {
		super();
		this.property_name = property_name;
		this.property_description = property_description;
	}
	
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
	@Override
	public String toString() {
		return "PropertyAccessValue [property_name=" + property_name + ", property_description=" + property_description
				+ "]";
	}
	

}
