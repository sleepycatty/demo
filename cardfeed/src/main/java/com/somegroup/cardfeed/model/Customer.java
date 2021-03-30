package com.somegroup.cardfeed.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String name;
	private CustomerType type;
	
	public Customer() {}
	
	public Customer(String name, CustomerType type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CustomerType getType() {
		return type;
	}
	public void setType(CustomerType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", type=" + type + "]";
	}
	
	
}
