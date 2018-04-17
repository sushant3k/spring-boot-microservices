package com.learning.microservices.customermanagement;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}
		
}

@RestController
class CMRestController {
	
	@RequestMapping(value="/customers", produces="application/json")
	public Customers getCustomers() {
		
		return new Customers("uid-1","John", "doe");
	}
}

class Customers implements Serializable {
	
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
