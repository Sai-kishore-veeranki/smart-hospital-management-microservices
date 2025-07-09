package com.vsk.hms_patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // From Lombok
import lombok.NoArgsConstructor; // From Lombok
import lombok.AllArgsConstructor; // From Lombok

@Entity // Marks this class as a JPA entity
@Data // Lombok: Generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates an all-argument constructor
public class Patient {
    @Id // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments ID
    private Long id;
    private String firstName;
    private String lastName;
    private String dob; // Date of Birth (e.g., "YYYY-MM-DD")
    private String gender;
    private String contactNumber;
    private String address;
    // Add fields relevant for ML prediction (e.g., from your dataset)
    private Double heightCm;
    private Double weightKg;
    private Double bloodGlucose;
    private Double bmi;
    private Integer pregnancies; // Example for diabetes prediction
    private Double insulin;
    private Double bloodPressure;
    private Double skinThickness;
    // ... add any other features your ML model might use for prediction
}
