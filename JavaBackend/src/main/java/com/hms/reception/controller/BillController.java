package com.hms.reception.controller;

import com.hms.patient.entity.Patient;
import com.hms.reception.service.BillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill/")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("generate-bill/{patientId}")
    public Patient generatePatientBill(@PathVariable int patientId){
        return billService.getPatientWithPendingPayment(patientId);
  }
}
