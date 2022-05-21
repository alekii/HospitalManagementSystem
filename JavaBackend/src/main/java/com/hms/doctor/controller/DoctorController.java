package com.hms.doctor.controller;

import com.hms.auth.services.UserDetailsServiceImpl;
import com.hms.common.model.Gender;
import com.hms.doctor.dto.MedicationDTO;
import com.hms.doctor.entity.Doctor;
import com.hms.doctor.payload.request.AddNewPatient;
import com.hms.patient.entity.Medication;
import com.hms.doctor.service.DoctorService;
import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        int doctorId = userDetailsService.getUserId(patientRequest.getDoctorUsername());   //find user
        if (doctorId == 0) return ("error");
        //id is 0 so add
        Doctor doctor = doctorService.findById(doctorId);
        Patient patient = new Patient();
        patient.setFirstName(patientRequest.getFirstName()) ;
        patient.setLastName(patientRequest.getLastName());
        patient.setAge(patientRequest.getAge());
        patient.setGender(Gender.valueOf(patientRequest.getGender()));
        doctor.getPatients().add(patient);
        doctorService.save(doctor);
       return ("Patient Added Successfully");
    }

    @GetMapping("/patients/find/all/{doctorUsername}")
    public  List<String[]> findAll(@PathVariable String doctorUsername) {
        int doctorId = userDetailsService.getUserId(doctorUsername);   //find user

        List<String[]> pListArr = new ArrayList<>();
        if (doctorId != 0) {
            Doctor doctor = doctorService.findById(doctorId);

            List<Patient> patients = new ArrayList<>(doctor.getPatients());

            for (Patient patient : patients) {
                String[] patientsList = new String[5];
                patientsList[0] = String.valueOf(patient.getId());
                patientsList[1] = patient.getFirstName();
                patientsList[2] = patient.getLastName();
                patientsList[3] = String.valueOf(patient.getAge());
                patientsList[4] = patient.getGender().name();
                pListArr.add(patientsList);
            }
            return pListArr;
        }
        return pListArr;
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
