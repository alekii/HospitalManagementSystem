package com.hms.utils.pdfgenerator.controller;

import com.hms.patient.entity.Medication;
import com.hms.patient.entity.Patient;
import com.hms.patient.service.PatientService;
import com.hms.utils.pdfgenerator.model.PatientBill;
import com.hms.utils.pdfgenerator.service.PatientBillService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.Thymeleaf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/bill/")
public class BillController {
    private final PatientBillService billService;
    private final PatientService patientService;

    public BillController(PatientBillService billService, PatientService patientService) {
        this.billService = billService;
        this.patientService = patientService;
    }

    @GetMapping("generate-bill/{patientId}")
    public String generatePatientBill(@PathVariable int patientId, Model theModel){
        Patient patient = billService.getPatientWithPendingPayment(patientId);
        Medication patientMedication = patientService.getMedication(patientId);
        PatientBill patientBill = new PatientBill();
        patientBill.setFirstName(patient.getFirstName());
        patientBill.setLastName(patient.getLastName());
        patientBill.setServiceRendered(patientMedication.getTreatment());
        patientBill.setAmountCharged(patientMedication.getTreatmentAmount());
        theModel.addAttribute("thePatientBill", patientBill);
        return "patient-bill";

  }
  @GetMapping("generate-pdf/{id}")
    public int generatepdf(@PathVariable int id ){
        System.out.println(id);
        return id;

  }

}
