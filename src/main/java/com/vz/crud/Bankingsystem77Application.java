package com.vz.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableCaching
public class Bankingsystem77Application {

	public static void main(String[] args) {
		SpringApplication.run(Bankingsystem77Application.class, args);
	}
	
	

}
