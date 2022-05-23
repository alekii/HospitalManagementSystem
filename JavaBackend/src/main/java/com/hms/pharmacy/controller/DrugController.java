package com.hms.pharmacy.controller;

import com.hms.pharmacy.request.DrugSale;
import com.hms.pharmacy.entity.Drug;
import com.hms.pharmacy.service.DrugService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs/")
@PreAuthorize("hasAuthority('PHARMACIST')")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @PostMapping("add")
    public String addDrug(@RequestBody Drug drug){
        drugService.addDrug(drug);
        return "Drug added successfully";
    }

    @GetMapping("find/{drugName}")
    public List<Drug> findDrug(@PathVariable String drugName){
        return  drugService.findDrug(drugName);
    }

     @PostMapping("sell")
    public double sellDrug(@RequestBody DrugSale drugSale){
        return  drugService.sellDrug(drugSale.getDrugId(),drugSale.getDrugQuantity());
     }
}
