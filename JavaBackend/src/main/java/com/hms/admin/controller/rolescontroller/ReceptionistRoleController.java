package com.hms.admin.controller.rolescontroller;

import com.hms.reception.entity.Receptionist;
import com.hms.reception.service.ReceptionistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees/receptionist/")
public class ReceptionistRoleController {
    private final ReceptionistService receptionistService;

    public ReceptionistRoleController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @PostMapping("add")
    public String addReceptionist(@RequestBody Receptionist receptionist){
        receptionistService.addReceptionist(receptionist);
        return "Added Receptionist Successfully";
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
