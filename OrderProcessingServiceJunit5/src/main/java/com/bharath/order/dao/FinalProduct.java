package com.bharath.order.dao;

public final class FinalProduct {
	private Integer id;
	private String name;
	
	public FinalProduct() {
		
	}
	
	public FinalProduct(Integer id, String name) {
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
