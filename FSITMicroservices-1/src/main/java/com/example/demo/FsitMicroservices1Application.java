package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class FsitMicroservices1Application {

	public static void main(String[] args) {
		SpringApplication.run(FsitMicroservices1Application.class, args);
	}

}
