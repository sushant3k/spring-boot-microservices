/**
 * 
 */
package com.learning.microservices.authServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ggne0084
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired
	// private AuthenticationManager authenticationManager;
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder userPasswordEncoder;
	

	public WebSecurityConfig(UserDetailsService userService) {
		this.userService = userService;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(userPasswordEncoder);
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	// @Bean(name = BeanIds.USER_DETAILS_SERVICE)
	// @Override
	// public UserService userDetailsServiceBean() throws Exception {
	//
	// return super.userDetailsServiceBean();
	// }

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/users");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
//		 http.requestMatchers().antMatchers("/login",
//		 "/oauth/authorize").and().authorizeRequests().anyRequest()
//		 .authenticated().and().formLogin().permitAll();

		
//		http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	//
	// auth.parentAuthenticationManager(authenticationManager)
	// .userDetailsService(userService);
	// }

}
