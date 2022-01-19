package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GutendexryDriver {
	
	private static Logger log = LoggerFactory.getLogger(GutendexryDriver.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GutendexryDriver.class, args);
		//log.info("Running");
		//log.warn("HEY WAITT");
	}
}