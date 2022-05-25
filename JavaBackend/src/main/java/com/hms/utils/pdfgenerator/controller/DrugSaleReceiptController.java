package com.hms.utils.pdfgenerator.controller;

import com.hms.accounts.service.DrugSaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/drugsalereceipt/")
public class DrugSaleReceiptController {
    private final DrugSaleService drugSaleService;

    public DrugSaleReceiptController(DrugSaleService drugSaleService) {
        this.drugSaleService = drugSaleService;
    }

    @GetMapping("find/")
    @PreAuthorize("hasAuthority('ADMIN) or hasAuthority('PHARMACIST')")

    public ResponseEntity<?> getDrugSaleReceipt(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        return null;
    }
}
