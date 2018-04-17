package com.learning.microservices.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.usermanagement.model.Customers;
import com.learning.microservices.usermanagement.restclient.CustomerManagementClient;

@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.learning.microservices.usermanagement.restclient")
@SpringBootApplication
@EnableHystrix
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
	
	
}

@RefreshScope
@RestController
class UMRestController{
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private CustomerManagementClient customerManagementClient;
	
	@Value("${name}")
	private String name;

	@RequestMapping(value="/users")
	public String getUser() {
		
		return name;
	}
	
	
	@RequestMapping(value="/users/{uid}")
	public List<ServiceInstance> getAllUsers(@PathVariable String uid) {
		
		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances("customer-management");
		if (serviceInstances == null || serviceInstances.isEmpty()) {
			return null;
		}
		
		return serviceInstances;
	}

	
	@RequestMapping(value="/users/{uid}/customers")
	public Customers getCustomersAssignedToUser(@PathVariable String uid) {
		
//		System.out.println("BASE URI.........................................");
//		System.out.println(serviceInstances.get(0).getUri().toString());
		return customerManagementClient.getCustomers();

//		if (cms != null && cms.getUserId() != null) {
//			if (cms.getUserId().equalsIgnoreCase(uid)) {
//				return cms;
//			}
//			else {
//				return null;
//			}
//		}
//		else {
//			return null;
//		}
	}
}

