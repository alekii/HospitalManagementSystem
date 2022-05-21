package com.hms.doctor.controller;

import com.hms.auth.services.UserDetailsServiceImpl;
import com.hms.doctor.dto.MedicationDTO;
import com.hms.doctor.entity.Doctor;
import com.hms.doctor.payload.request.AddNewPatient;
import com.hms.patient.entity.Medication;
import com.hms.doctor.service.DoctorService;
import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/doctor/")
@PreAuthorize("hasAuthority('DOCTOR')")
public class DoctorController {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final UserDetailsServiceImpl userDetailsService;


    public DoctorController(DoctorService doctorService, PatientService patientService, UserDetailsServiceImpl userDetailsService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("patients/add")
    public String addPatient(@RequestBody AddNewPatient patientRequest){
        int doctorId = userDetailsService.getUserId(patientRequest.getDoctorUsername());
       // if (userId == 0) return ("Username already exists, please choose another username");
        Doctor doctor = doctorService.findById(31);
        Set<Patient> patientSet = new LinkedHashSet<>();
        Patient patient = new Patient();
        patient.setFirstName(patientRequest.getFirstName()) ;
        patient.setLastName(patientRequest.getLastName());
        patient.setAge(patientRequest.getAge());
        patientSet.add(patient);
        doctor.setPatients(patientSet);
        doctorService.save(doctor);
       return ("Patient Added Successfully");
    }

    @PutMapping("patients/update")
    public  String updatePatient(@RequestBody Patient patient){
        patientService.updatePatient(patient);
        return "patient updated successfully";
    }

@PostMapping("patients/medication/add")
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
