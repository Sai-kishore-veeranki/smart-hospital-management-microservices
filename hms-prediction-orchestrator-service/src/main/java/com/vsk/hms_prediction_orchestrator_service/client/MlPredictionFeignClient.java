package com.vsk.hms_prediction_orchestrator_service.client;


import com.vsk.hms_prediction_orchestrator_service.dto.MlPredictionRequest;
import com.vsk.hms_prediction_orchestrator_service.dto.MlPredictionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// The 'url' attribute points directly to your Flask API's host and port.
// Ensure your Flask application is running on http://localhost:5000 when you test this.
@FeignClient(name = "ml-prediction-service", url = "http://localhost:5000")
public interface MlPredictionFeignClient {

    // This method definition maps to a POST request to "/predict-health-risk"
    // on your Flask server, sending MlPredictionRequest as JSON body
    // and expecting MlPredictionResponse back.
    @PostMapping("/predict-health-risk")
    MlPredictionResponse predictHealthRisk(@RequestBody MlPredictionRequest request);
}
