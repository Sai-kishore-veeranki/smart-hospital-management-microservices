package com.vsk.hms_prediction_orchestrator_service.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MlPredictionResponse {
    // These fields MUST match the keys and data types your Flask API returns in its JSON response
    private String disease;      // e.g., "Diabetes", "Heart Disease"
    private String riskLevel;    // e.g., "High", "Medium", "Low"
    private Double probability;  // e.g., 0.85
}
