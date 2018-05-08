/**
 * 
 */
package com.learning.microservices.usermanagement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * @author Sushant
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		

        resources.tokenStore(tokenStore()).resourceId("resource-server-rest-api");
        
    }
	
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		
////		http.authorizeRequests().antMatchers("/refresh/**","/actuator/*").permitAll();
//	}
	
	
	@Bean
	public AccessTokenConverter accessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}
	
	
//  @Primary
//  @Bean
//  public RemoteTokenServices tokenService() {
//      RemoteTokenServices tokenService = new RemoteTokenServices();
//      
//      tokenService.setCheckTokenEndpointUrl(
//              "http://ggnlabvm-mqoe02:8090/uaa/oauth/check_token");
//      tokenService.setClientId("acme");
//      tokenService.setClientSecret("spring-security-oauth2-read-client-password1234");
//      tokenService.setAccessTokenConverter(accessTokenConverter());
//      
//      System.out.println("------------------------- Un Checked token-------------------------------------");
//      System.out.println(tokenService);
//      return tokenService;
//  }
	
	
}
