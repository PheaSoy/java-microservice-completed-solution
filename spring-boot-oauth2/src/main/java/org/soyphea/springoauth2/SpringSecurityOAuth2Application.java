package org.soyphea.springoauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
public class SpringSecurityOAuth2Application{
	
	private static Class<SpringSecurityOAuth2Application> klazz = SpringSecurityOAuth2Application.class;
	
	private Logger logger = LoggerFactory.getLogger(klazz.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(klazz, args);
	}

	
}
