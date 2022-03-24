package com.apigateway.apigatewayApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApigatewayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayAppApplication.class, args);
	}

}
