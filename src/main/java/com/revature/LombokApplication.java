package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LombokApplication {
	
	private static Logger log = LoggerFactory.getLogger(LombokApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
		log.info("Running");
	}

}
