package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//http://websystique.com/spring-boot/spring-boot-rest-api-example/
// https://www.baeldung.com/spring-mvc-controller-custom-http-status-code - http-status-code for exception handler 
// https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg - swagger and exception handler 


// create the Spring Boot initializer class, this is the entry point of our application.
// Annotating a class with @SpringBootApplication is equivalent to using @Configuration, @EnableAutoConfiguration 
// and @ComponentScan with their default attributes in the traditional Spring applications.
@SpringBootApplication(scanBasePackages={"com"})
public class ApplicationConfiguration extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
		System.out.println("ApplicationConfiguration configure :: " );		
		return builder.sources(ApplicationConfiguration.class);
	}
   
	public static void main(String[] args) {
		System.out.println("ApplicationConfiguration main :: " );
		SpringApplication.run(ApplicationConfiguration.class,args);
		
	}
	
	
	
	

}
