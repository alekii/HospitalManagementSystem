package com.hms.accounts.controller.accounts;

import com.hms.accounts.dto.DrugSaleDTO;
import com.hms.accounts.dto.TreatmentRevenueDTO;
import com.hms.accounts.request.FetchByDate;
import com.hms.accounts.entity.DrugSale;
import com.hms.accounts.entity.TreatmentRevenue;
import com.hms.accounts.service.DrugSaleService;
import com.hms.accounts.service.TreatmentRevenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revenue/")
public class RevenueController {
    private final DrugSaleService drugSaleService;
    private final TreatmentRevenueService treatmentRevenueService;
    private FetchByDate fetchByDate;

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

    @GetMapping("drugsales/find")
    public List<DrugSaleDTO> findDrugSales(@RequestBody FetchByDate fetchByDate){
        return drugSaleService.getDrugSalesBetweenTwoDates(fetchByDate.getFromDate(),fetchByDate.getToDate());
    }

    @GetMapping("treatmentRevenue/find")
    public List<TreatmentRevenueDTO> findTreatmentRevenue(@RequestBody FetchByDate fetchByDate){
        return  treatmentRevenueService.getTreatmentRevenueBetweenTwoDates(fetchByDate.getFromDate(),fetchByDate.getToDate());
    }
}
