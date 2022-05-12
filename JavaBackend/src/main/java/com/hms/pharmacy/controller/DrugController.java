package com.hms.pharmacy.controller;

import com.hms.pharmacy.request.DrugSale;
import com.hms.pharmacy.entity.Drug;
import com.hms.pharmacy.service.DrugService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drugs/")
public class DrugController {
    private DrugService drugService;

    @PostMapping("add")
    public String addDrug(@RequestBody Drug drug){
        drugService.addDrug(drug);
        return "Drug added successfully";
    }

    @GetMapping("find/{drugId}")
    public Drug findDrug(@RequestBody int drugId){
        return  drugService.findDrug(drugId);
    }

     @PostMapping("sell")
    public double sellDrug(@RequestBody DrugSale drugSale){
        return  drugService.sellDrug(drugSale.getDrugId(),drugSale.getDrugQuantity());
     }
}
