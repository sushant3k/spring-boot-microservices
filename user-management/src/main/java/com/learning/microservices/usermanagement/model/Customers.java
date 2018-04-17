package com.learning.microservices.usermanagement.model;

public class Customers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String customerFirstName;
	private String customerSecondName;
	
	public Customers(String userId, String customerFirstName, String customerSecondName) {
		this.userId = userId;
		this.customerFirstName = customerFirstName;
		this.customerSecondName = customerSecondName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerSecondName() {
		return customerSecondName;
	}

	public void setCustomerSecondName(String customerSecondName) {
		this.customerSecondName = customerSecondName;
	}
	
}
