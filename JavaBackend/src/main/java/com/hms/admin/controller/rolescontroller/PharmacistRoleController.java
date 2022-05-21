package com.hms.admin.controller.rolescontroller;

import com.hms.admin.requests.OtherCareerRequest;
import com.hms.auth.services.UserDetailsServiceImpl;
import com.hms.common.model.Gender;
import com.hms.doctor.entity.Doctor;
import com.hms.pharmacy.entity.Pharmacist;
import com.hms.pharmacy.service.PharmacistService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees/pharmacists/")
@PreAuthorize("hasAuthority('ADMIN')")
public class PharmacistRoleController {
    private final PharmacistService pharmacistService;
    private final UserDetailsServiceImpl userDetailsService;

    public PharmacistRoleController(PharmacistService pharmacistService, UserDetailsServiceImpl userDetailsService) {
        this.pharmacistService = pharmacistService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("add")
    public String addPharmacist(@RequestBody OtherCareerRequest request){
        //find user
        int userId = userDetailsService.getUserId(request.getUserName());
        if (userId == 0) return ("Username already exists, please choose another username");
        //id is 0 so add
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setId(userId);
        pharmacist.setFirstName(request.getFirstName());
        pharmacist.setLastName(request.getLastName());
        pharmacist.setAge(request.getAge());
        pharmacist.setEmail(request.getEmail());
        Gender gender = Gender.valueOf(request.getGender());

        pharmacist.setGender(gender);
        pharmacistService.addPharmacist(pharmacist);
        return "Pharmacist added successfully";
    }

    @PutMapping("update")
    public String updatePharmacist(@RequestBody Pharmacist pharmacist){
        pharmacistService.updatePharmacist(pharmacist);
        return "Pharmacist added successfully";
    }

    @GetMapping("find/all")
    public List<Pharmacist> findAll(){
        return pharmacistService.findAll();
    }

    @GetMapping("find/{pharmacistId}")
    public Pharmacist findById(@PathVariable int pharmacistId){
         return pharmacistService.findPharmacistById(pharmacistId);
    }

    @DeleteMapping("delete/{pharmacistId}")
    public String deletePharmacist(@PathVariable int pharmacistId){
        pharmacistService.deletePharmacist(pharmacistId);
        return "Pharmacist with id "+pharmacistId+" "+"was deleted successfully";
    }
}
