package com.gameZome.dataHandler.datahandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DatahandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatahandlerApplication.class, args);
	}

}
