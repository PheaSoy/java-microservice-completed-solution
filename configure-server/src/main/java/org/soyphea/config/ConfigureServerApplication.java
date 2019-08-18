package org.soyphea.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigureServerApplication {
	
	public static void main(String[] args) {
		//SpringApplication.run(ConfigureServerApplication.class, args);
		new ConfigureServerApplication().test1();
	}
	
	
	public  void test1() {
		
		String text = "pl";
		//String defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
		String defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
		System.out.println(defaultText);
		
	}
	public String getDefaultValue() {
	    System.out.println("Getting Default Value11");
	    return "Default Value";
	}
}