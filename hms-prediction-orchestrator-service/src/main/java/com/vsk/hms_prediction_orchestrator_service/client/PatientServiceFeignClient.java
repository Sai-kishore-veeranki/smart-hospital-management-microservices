package com.vsk.hms_prediction_orchestrator_service.client;

import com.vsk.hms_prediction_orchestrator_service.controller.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hms-patient-service")
public interface PatientServiceFeignClient {

    @GetMapping("/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}

