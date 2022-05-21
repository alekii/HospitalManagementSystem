package com.hms.patient.controller;

import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients/")
@PreAuthorize("hasAuthority('DOCTOR')")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("find/{patientId}")
    public Patient findPatient(@PathVariable int patientId) {
        return patientService.findPatient(patientId);
    }

}

