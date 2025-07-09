package com.vsk.hms_patient_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HmsPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsPatientServiceApplication.class, args);
	}

}
