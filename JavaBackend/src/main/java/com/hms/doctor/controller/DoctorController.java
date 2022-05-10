package com.hms.doctor.controller;

import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import com.hms.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
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

    public String AddMedication(@RequestBody Medication medicationRequest){
        doctorService.addMedication(medicationRequest);
        return "Added successfully";
    }
}
