/**
 * 
 */
package com.learning.microservices.usermanagement.hystrixfallback;

import org.springframework.stereotype.Component;

import com.learning.microservices.usermanagement.model.Customers;
import com.learning.microservices.usermanagement.restclient.CustomerManagementClient;

/**
 * @author ggne0084
 *
 */
@Component
public class CustomerManagementFallback implements CustomerManagementClient{

	@Override
	public Customers getCustomers() {	
		return new Customers("temp", "fname", "sname");
	}

	
}
