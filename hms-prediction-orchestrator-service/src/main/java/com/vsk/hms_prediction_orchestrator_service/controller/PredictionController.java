package com.vsk.hms_prediction_orchestrator_service.controller;

import com.vsk.hms_prediction_orchestrator_service.client.MlPredictionFeignClient;
import com.vsk.hms_prediction_orchestrator_service.client.PatientServiceFeignClient;
import com.vsk.hms_prediction_orchestrator_service.dto.MlPredictionRequest;
import com.vsk.hms_prediction_orchestrator_service.dto.MlPredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/predictions")
public class PredictionController {

    @Autowired
    private MlPredictionFeignClient mlPredictionFeignClient;

    @Autowired
    private PatientServiceFeignClient patientServiceFeignClient;

    @PostMapping("/risk-assessment/{patientId}")
    public ResponseEntity<MlPredictionResponse> getHealthRiskPrediction(@PathVariable Long patientId) {
        try {
            // Step 1: Fetch patient details from patient service
            PatientDTO patient = patientServiceFeignClient.getPatientById(patientId);

            // Step 2: Map PatientDTO to MlPredictionRequest
            MlPredictionRequest request = new MlPredictionRequest();
            request.setAge(calculateAge(patient.getDob()));
            request.setBmi(patient.getBmi());
            request.setGlucose(patient.getBloodGlucose());
            request.setPregnancies(patient.getPregnancies());
            request.setInsulin(patient.getInsulin());
            request.setBloodPressure(patient.getBloodPressure());
            request.setSkinThickness(patient.getSkinThickness());

            // Step 3: Send request to ML API
            MlPredictionResponse response = mlPredictionFeignClient.predictHealthRisk(request);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    private int calculateAge(String dob) {
        return Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
    }
}
