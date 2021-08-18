package com.bharath.order.dao;

public class Product {
	private Integer id;
	private String name;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return new Integer(1);
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
