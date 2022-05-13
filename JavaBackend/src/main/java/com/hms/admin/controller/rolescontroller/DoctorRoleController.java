package com.hms.admin.controller.rolescontroller;

import com.hms.doctor.entity.Doctor;
import com.hms.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/employees/doctors/")
public class DoctorRoleController {
    private final DoctorService doctorService;

    public DoctorRoleController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("find/all")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("doctor/find/{doctorId}")
    public Doctor findDoctor(@PathVariable int doctorId){
        return doctorService.findById(doctorId);
    }

    @PostMapping("doctors/add")
    public  Doctor addDoctor(@RequestBody Doctor doctor){
        //id is 0 so add
        doctor.setEmployeeId(0);
        doctorService.save(doctor);
        return doctor;
    }
    @PutMapping("doctors/update")
    public  Doctor updateDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return doctor;
    }
    @DeleteMapping("doctors/delete/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId){
        Optional<Doctor> doctor = Optional.ofNullable(doctorService.findById(doctorId));
        if(doctor.isEmpty()){
            return "Doctor with given Id does not exist";
        }
        doctorService.delete(doctorId);
        return "Deleted Doctor with Id "+doctorId;
    }
}
