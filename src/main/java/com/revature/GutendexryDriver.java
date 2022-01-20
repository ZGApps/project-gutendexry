package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GutendexryDriver {
	
	private static Logger log = LoggerFactory.getLogger(GutendexryDriver.class);
	
	/**
	 * Spring Security
	 * It is recommended to just declare a 
	 * WebMvcConfigurer bean as below...
	 * This is an extra measure against CORS errors.
	 * https://spring.io/blog/2015/06/08/cors-support-in-spring-framework#spring-boot-integration
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedHeaders("*").allowedOriginPatterns("*").allowedMethods("*")/*.allowCredentials(true)*/;
			}
		};
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(GutendexryDriver.class, args);
		//log.info("Running");
		//log.warn("HEY WAITT");
	}
}