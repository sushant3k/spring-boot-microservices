package com.learning.microservices.authServer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncoding {

	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("pwd123");
		System.out.println(result);
		System.out.println(encoder.matches("pwd123", result));
	}
}
