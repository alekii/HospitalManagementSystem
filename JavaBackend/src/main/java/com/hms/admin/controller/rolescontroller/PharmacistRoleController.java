package com.hms.admin.controller.rolescontroller;

import com.hms.pharmacy.entity.Pharmacist;
import com.hms.pharmacy.service.PharmacistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees/pharmacists/")
public class PharmacistRoleController {
    private final PharmacistService pharmacistService;

    public PharmacistRoleController(PharmacistService pharmacistService) {
        this.pharmacistService = pharmacistService;
    }

    @PostMapping("add")
    public String addPharmacist(@RequestBody Pharmacist pharmacist){
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
