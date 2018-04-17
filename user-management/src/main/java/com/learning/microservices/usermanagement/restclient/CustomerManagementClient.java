/**
 * 
 */
package com.learning.microservices.usermanagement.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.microservices.usermanagement.hystrixfallback.CustomerManagementFallback;
import com.learning.microservices.usermanagement.model.Customers;

/**
 * @author Sushant
 *
 */
@FeignClient(name="CUSTOMER-MANAGEMENT",fallback=CustomerManagementFallback.class)
public interface CustomerManagementClient {

	@RequestMapping(value="/customers", produces="application/json")
	public Customers getCustomers() ;
}

