package com.hms.accounts.controller;

import com.hms.accounts.entity.DrugSaleReceipt;
import com.hms.accounts.request.DrugSaleRequest;
import com.hms.accounts.request.TreatmentRevenueRequest;
import com.hms.accounts.request.FetchByDate;
import com.hms.accounts.entity.DrugSale;
import com.hms.accounts.entity.TreatmentRevenue;
import com.hms.accounts.service.DrugSaleService;
import com.hms.accounts.service.TreatmentRevenueService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/revenue/")
public class RevenueController {
    private final DrugSaleService drugSaleService;
    private final TreatmentRevenueService treatmentRevenueService;
    private FetchByDate fetchByDate;

    public RevenueController(DrugSaleService drugSaleService, TreatmentRevenueService treatmentRevenueService) {
        this.drugSaleService = drugSaleService;
        this.treatmentRevenueService = treatmentRevenueService;
    }

    @PostMapping(value = "drugsale/add", consumes = "application/json")
    @PreAuthorize("hasAuthority('PHARMACIST')")
    public String addDrugSale(@RequestBody DrugSaleRequest drugSaleRequest){
        //System.out.println(drugSaleRequest);
        DrugSaleReceipt drugSaleReceipt  = new DrugSaleReceipt();
        drugSaleRequest.getDrugSaleList().forEach(drugSale->{
            drugSaleReceipt.addReceipt(drugSale);
        });  
        drugSaleService.addDrugSaleReceipt(drugSaleReceipt);
        return "Drug Sale added Successfully";
    }

    @PostMapping("treatment/add")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public String addTreatmentRevenue(@RequestBody TreatmentRevenue treatmentRevenue){
        treatmentRevenueService.saveTreatmentRevenue(treatmentRevenue);
        return "Treatment Revenue Sale added Successfully";
    }

    @GetMapping("drugsales/find")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<DrugSaleRequest> findDrugSales(@RequestBody FetchByDate fetchByDate){
        return drugSaleService.getDrugSalesBetweenTwoDates(fetchByDate.getFromDate(),fetchByDate.getToDate());
    }

    @GetMapping("treatmentrevenue/find")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TreatmentRevenueRequest> findTreatmentRevenue(@RequestBody FetchByDate fetchByDate){
        return  treatmentRevenueService.getTreatmentRevenueBetweenTwoDates(fetchByDate.getFromDate(),fetchByDate.getToDate());
    }
}
