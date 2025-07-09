package com.vsk.hms_patient_service.controller;

import com.vsk.hms_patient_service.model.Patient;
import com.vsk.hms_patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST Controller
@RequestMapping("/patients") // Base path for all endpoints in this controller
public class PatientController {

    @Autowired // Injects the PatientRepository
    private PatientRepository patientRepository;

    @GetMapping // Handles GET requests to /patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}") // Handles GET requests to /patients/{id}
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.map(ResponseEntity::ok) // If patient found, return 200 OK with patient
                .orElse(ResponseEntity.notFound().build()); // Else, return 404 Not Found
    }

    @PostMapping // Handles POST requests to /patients
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created status
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}") // Handles PUT requests to /patients/{id}
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(patientDetails.getFirstName());
                    patient.setLastName(patientDetails.getLastName());
                    patient.setDob(patientDetails.getDob());
                    patient.setGender(patientDetails.getGender());
                    patient.setContactNumber(patientDetails.getContactNumber());
                    patient.setAddress(patientDetails.getAddress());
                    patient.setHeightCm(patientDetails.getHeightCm());
                    patient.setWeightKg(patientDetails.getWeightKg());
                    patient.setBloodGlucose(patientDetails.getBloodGlucose());
                    patient.setBmi(patientDetails.getBmi());
                    patient.setPregnancies(patientDetails.getPregnancies());
                    patient.setInsulin(patientDetails.getInsulin());
                    patient.setBloodPressure(patientDetails.getBloodPressure());
                    patient.setSkinThickness(patientDetails.getSkinThickness());

                    Patient updatedPatient = patientRepository.save(patient);
                    return ResponseEntity.ok(updatedPatient);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // Handles DELETE requests to /patients/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT) // Returns 204 No Content status
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
