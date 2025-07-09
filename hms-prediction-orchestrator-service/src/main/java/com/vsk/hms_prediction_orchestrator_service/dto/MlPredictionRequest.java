package com.vsk.hms_prediction_orchestrator_service.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MlPredictionRequest {
    // These fields MUST match the keys and data types your Flask API expects in its JSON payload
    private Integer age;
    private Double bmi;
    private Double glucose;
    private Integer pregnancies;
    private Double insulin;
    private Double bloodPressure;
    private Double skinThickness;
    // Add any other features your ML model uses
}