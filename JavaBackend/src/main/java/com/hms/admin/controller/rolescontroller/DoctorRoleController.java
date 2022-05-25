package com.hms.admin.controller.rolescontroller;

import com.hms.admin.requests.DoctorRequest;
import com.hms.auth.services.UserDetailsServiceImpl;
import com.hms.common.model.Gender;
import com.hms.doctor.entity.Doctor;
import com.hms.doctor.service.DoctorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/employees/doctors/")
@PreAuthorize("hasAuthority('ADMIN')")
public class DoctorRoleController {
    private final DoctorService doctorService;

    private final UserDetailsServiceImpl userDetailsService;

    public DoctorRoleController(DoctorService doctorService, UserDetailsServiceImpl userDetailsService) {
        this.doctorService = doctorService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("find/all")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("find/{doctorUsername}")
    public Doctor findDoctor(@PathVariable int doctorId){
        return doctorService.findById(doctorId);
    }

    @PostMapping("add")
    public  String addDoctor(@RequestBody DoctorRequest doctorRequest){
        //find
        int userId = userDetailsService.getUserId(doctorRequest.getUserName());
        if (userId == 0) return ("Username already exists, please choose another username");
        //id is 0 so add
        Doctor doctor = new Doctor();
        doctor.setId(userId);
        doctor.setFirstName(doctorRequest.getFirstName());
        doctor.setLastName(doctorRequest.getLastName());
        doctor.setAge(doctorRequest.getAge());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setSpeciality(doctorRequest.getSpeciality());
        Gender gender = Gender.valueOf(doctorRequest.getGender());

        doctor.setGender(gender);
        doctor.setRoom(doctorRequest.getRoom());
        doctorService.save(doctor);
        return "doctor added successfully";
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
