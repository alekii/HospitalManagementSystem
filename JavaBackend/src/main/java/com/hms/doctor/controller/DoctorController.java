package com.hms.doctor.controller;

import com.hms.doctor.dto.MedicationDTO;
import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import com.hms.doctor.service.DoctorService;
import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class DoctorController {
    private final DoctorService doctorService;
    private final PatientService patientService;

    public DoctorController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @PutMapping("/doctors/update")
    public  Doctor updateDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return doctor;
    }
    @PutMapping("/patients/update")
    public  String updatePatient(@RequestBody Patient patient){
        patientService.updatePatient(patient);
        return "patient updated successfully";
    }

@PostMapping("/patients/medication/add")
    public String AddMedication(@RequestBody MedicationDTO medicationDTO){
        Patient patient = patientService.findPatient(medicationDTO.getPatientId());
        Medication medication = new Medication();
        medication.setDiagnosis(medicationDTO.getDiagnosis());
        medication.setDrugs(medicationDTO.getDrugs());
        medication.setTreatment(medicationDTO.getTreatment());
        medication.setTreatmentAmount(medicationDTO.getTreatmentAmount());
        patientService.addMedication(patient.getId(),medication);
        return "Medication for "+patient.getFirstName() +" " +patient.getLastName() +" Added successfully";
    }
}
