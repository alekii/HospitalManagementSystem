package com.hms.accounts.controller.accounts;

import com.hms.accounts.entity.DrugSale;
import com.hms.accounts.entity.TreatmentRevenue;
import com.hms.accounts.service.DrugSaleService;
import com.hms.accounts.service.TreatmentRevenueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/revenue/")
public class RevenueController {
    private final DrugSaleService drugSaleService;
    private final TreatmentRevenueService treatmentRevenueService;

    public RevenueController(DrugSaleService drugSaleService, TreatmentRevenueService treatmentRevenueService) {
        this.drugSaleService = drugSaleService;
        this.treatmentRevenueService = treatmentRevenueService;
    }

    @PostMapping("drugsale/add")
    public String addDrugSale(@RequestBody DrugSale drugSale){
        drugSaleService.addDrugSale(drugSale);
        return "Drug Sale added Successfully";
    }

    @PostMapping("treatment/add")
    public String addTreatmentRevenue(@RequestBody TreatmentRevenue treatmentRevenue){
        treatmentRevenueService.saveTreatmentRevenue(treatmentRevenue);
        return "Treatment Revenue Sale added Successfully";
    }
}
