package com.learning.microservices.authServer;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableAuthorizationServer
@RestController
@ComponentScan(basePackages="com.learning.microservices.authServer")
public class AuthServerApplication {

	
	private static final Log logger = LogFactory.getLog(AuthServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@RequestMapping("/user")
    public Principal user(Principal user) {
		logger.info("AS /user has been called");
	    logger.debug("user info: "+user.toString());
        return user;
    }
}
