package com.hms.pharmacy.controller;

import com.hms.pharmacy.request.DrugSale;
import com.hms.pharmacy.entity.Drug;
import com.hms.pharmacy.service.DrugService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs/")
public class DrugController {
    private DrugService drugService;

    @PostMapping("add")
    public String addDrug(@RequestBody Drug drug){
        drugService.addDrug(drug);
        return "Drug added successfully";
    }

    @GetMapping("find/{drugName}")
    public List<Drug> findDrug(@RequestBody String drugName){
        return  drugService.findDrug(drugName);
    }

     @PostMapping("sell")
    public double sellDrug(@RequestBody DrugSale drugSale){
        return  drugService.sellDrug(drugSale.getDrugId(),drugSale.getDrugQuantity());
     }
}
