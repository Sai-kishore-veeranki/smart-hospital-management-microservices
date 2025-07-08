package com.vsk.hms_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HmsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsApiGatewayApplication.class, args);
	}

}
