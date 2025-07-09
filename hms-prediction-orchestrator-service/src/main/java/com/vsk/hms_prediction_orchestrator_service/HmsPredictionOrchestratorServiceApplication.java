package com.vsk.hms_prediction_orchestrator_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HmsPredictionOrchestratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsPredictionOrchestratorServiceApplication.class, args);
	}

}
