package com.hms.admin.controller.rolescontroller;

import com.hms.reception.entity.Receptionist;
import com.hms.reception.service.ReceptionistService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees/receptionist/")
public class ReceptionistConroller {
    private final ReceptionistService receptionistService;

    public ReceptionistConroller(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    public String addReceptionist(@RequestBody Receptionist receptionist){
        receptionistService.addReceptionist(receptionist);
        return "Added Receptionist Successfully";
    }
}
