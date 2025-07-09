package com.vsk.hms_patient_service.repository;


import com.vsk.hms_patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring Data JPA repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Spring Data JPA automatically provides basic CRUD operations (save, findById, findAll, delete)
    // You can add custom finder methods here if needed, e.g.:
    // Optional<Patient> findByLastName(String lastName);
}
