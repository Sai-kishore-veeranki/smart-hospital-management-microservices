package com.vsk.hms_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsEurekaServerApplication.class, args);
	}

}
