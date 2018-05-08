/**
 * 
 */
package com.learning.microservices.authServer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * @author Sushant
 *
 */

@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	// @Autowired
	// public void setUserDetailsService(UserService userDetailsService) {
	// this.userDetailsService = userDetailsService;
	// }

	//

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userService;

	

	@Autowired
	private PasswordEncoder oauthClientPasswordEncoder;

	// @Autowired
	// public void setAuthenticationManager(AuthenticationManager
	// authenticationManager) {
	// this.authenticationManager = authenticationManager;
	// }

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				 .userDetailsService(userService)
				.tokenStore(tokenStore());
//				 .tokenStore(new InMemoryTokenStore());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.jdbc(dataSource);
//		clients
//        .inMemory()
//        .withClient("acme")
//        .secret("$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km")
//        .authorizedGrantTypes("client_credentials", "password", "refresh_tokens")
//        .scopes("read", "write")
//        .accessTokenValiditySeconds(120)
//        .and()
//        .withClient("acme2")
//        .secret("$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km")
//        .authorizedGrantTypes("client_credentials", "password", "refresh_tokens")
//        .scopes("read", "write")
//        .accessTokenValiditySeconds(120)
//        ;
//        .resourceIds("sample-oauth");
		
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(oauthClientPasswordEncoder);
		security.allowFormAuthenticationForClients().checkTokenAccess("permitAll()").passwordEncoder(oauthClientPasswordEncoder);
		// .allowFormAuthenticationForClients();
	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
		return new OAuth2AccessDeniedHandler();
	}
	
	

}
