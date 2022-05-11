package com.hms.doctor.controller;

import com.hms.doctor.dto.MedicationDTO;
import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import com.hms.doctor.service.DoctorService;
import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;
    private final PatientService patientService;

    public DoctorController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/doctor/{doctorId}")
    public Doctor findDoctor(@PathVariable int doctorId){
        return doctorService.findById(doctorId);
    }

    @PostMapping("/doctors/add")
    public  Doctor addDoctor(@RequestBody Doctor doctor){
        //id is 0 so add
        doctor.setId(0);
        doctorService.save(doctor);
        return doctor;
    }

    @PutMapping("/doctors/update")
    public  Doctor updateDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return doctor;
    }

    @DeleteMapping("/doctors/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId){
        Optional<Doctor> doctor = Optional.ofNullable(doctorService.findById(doctorId));
        if(doctor.isEmpty()){
            return "Doctor with given Id does not exist";
        }
        doctorService.delete(doctorId);
        return "Deleted Doctor with Id "+doctorId;
    }

@PostMapping("/doctors/patients/medication/add")
    public String AddMedication(@RequestBody MedicationDTO medicationDTO){
        Patient patient = patientService.findPatient(medicationDTO.getPatientId());
        Medication medication = new Medication();
        medication.setDiagnosis(medicationDTO.getDiagnosis());
        medication.setDrugs(medicationDTO.getDrugs());
        medication.setTreatment(medicationDTO.getTreatment());
        medication.setTreatmentAmount(medicationDTO.getTreatmentAmount());
        medication.setPatient(patient);
        patientService.addMedication(medication);
        return "Medication for "+patient.getFirstName() +" " +patient.getLastName() +" Added successfully";
    }
}
