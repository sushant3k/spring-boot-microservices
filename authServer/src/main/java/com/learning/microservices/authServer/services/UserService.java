/**
 * 
 */
package com.learning.microservices.authServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.microservices.authServer.entities.User;
import com.learning.microservices.authServer.repository.UserRepository;

/**
 * @author Sushant
 *
 */
@Service
public class UserService implements UserDetailsService{

	private UserRepository userRepository;
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}


	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	@Transactional
	public User loadUserByUsername(String arg0) throws UsernameNotFoundException {
		System.out.println("Fetching.................. user, " + arg0);
		User ud = userRepository.findOneByUsername(arg0);
		
		System.out.println(ud.getUsername() + "/" + ud.getPassword() + "/ac locked:" + ud.isAccountLocked() + "/ac.expired: " + ud.isAccountExpired() + "/ac.credentialsExpired: " + ud.isCredentialsExpired());
		return ud;
	}

}
