/**
 * 
 */
package com.learning.microservices.authServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.microservices.authServer.entities.User;

/**
 * @author Sushant
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findOneByUsername(String username);
}
