package com.hms.admin.controller.rolescontroller;

import com.hms.admin.requests.OtherCareerRequest;
import com.hms.auth.services.UserDetailsServiceImpl;
import com.hms.common.model.Gender;
import com.hms.reception.entity.Receptionist;
import com.hms.reception.service.ReceptionistService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees/receptionists/")
@PreAuthorize("hasAuthority('ADMIN')")
public class ReceptionistRoleController {
    private final ReceptionistService receptionistService;
    private final UserDetailsServiceImpl userDetailsService;

    public ReceptionistRoleController(ReceptionistService receptionistService, UserDetailsServiceImpl userDetailsService) {
        this.receptionistService = receptionistService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("add")
    public String addReceptionist(@RequestBody OtherCareerRequest request){
        int userId = userDetailsService.getUserId(request.getUserName());
        if (userId == 0) return ("Username already exists, please choose another username");
        //id is 0 so add
        Receptionist receptionist = new Receptionist();
        receptionist.setId(userId);
        receptionist.setFirstName(request.getFirstName());
        receptionist.setLastName(request.getLastName());
        receptionist.setAge(request.getAge());
        receptionist.setEmail(request.getEmail());
        Gender gender = Gender.valueOf(request.getGender());

        receptionist.setGender(gender);
        receptionistService.addReceptionist(receptionist);
        return "Receptionist added successfully";
    }

    @GetMapping("find/all")
    public List<Receptionist> findAll(){
        return receptionistService.findAll();
    }

    @GetMapping("find/{receptionistId}")
    public Receptionist findById(@PathVariable int receptionistId){
        return receptionistService.findReceptionistById(receptionistId);
    }

    @PutMapping("update")
    public String updateReceptionist(@RequestBody Receptionist receptionist) {
        receptionistService.updateReceptionist(receptionist);
        return "Update Receptionist successfully";
    }

    @DeleteMapping("delete/{receptionistId}")
    public String deleteReceptionist(@PathVariable int receptionistId) {
        receptionistService.deleteReceptionist(receptionistId);
        return "Receptionist deleted successfully";
    }
}
