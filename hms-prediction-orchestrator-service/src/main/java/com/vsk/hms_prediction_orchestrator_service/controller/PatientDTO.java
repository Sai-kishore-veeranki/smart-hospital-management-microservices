package com.vsk.hms_prediction_orchestrator_service.controller;


import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String contactNumber;
    private String address;

    private Double heightCm;
    private Double weightKg;
    private Double bloodGlucose;
    private Double bmi;
    private Integer pregnancies;
    private Double insulin;
    private Double bloodPressure;
    private Double skinThickness;
}

