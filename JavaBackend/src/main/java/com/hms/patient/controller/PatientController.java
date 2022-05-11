package com.hms.patient.controller;

import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients/")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/find/{patientId}")
    public Patient findPatient(@PathVariable int patientId){
        return patientService.findPatient(patientId);
    }
}
