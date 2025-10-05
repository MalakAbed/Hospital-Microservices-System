package com.druginteractionchecker.druginteractioncheckerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DrugInteractionCheckerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugInteractionCheckerServiceApplication.class, args);
	}

}