package com.hms.accounts.service;

import com.hms.accounts.dao.DrugSaleDAO;
import com.hms.accounts.dao.DrugSaleReceiptDAO;
import com.hms.accounts.entity.DrugSaleReceipt;
import com.hms.accounts.request.DrugSaleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DrugSaleService {
    private final DrugSaleReceiptDAO drugSaleReceiptDAO;
    private final DrugSaleDAO drugSaleDAO;

    public DrugSaleService(DrugSaleReceiptDAO drugSaleReceiptDAO, DrugSaleDAO drugSaleDAO) {
        this.drugSaleReceiptDAO = drugSaleReceiptDAO;
        this.drugSaleDAO = drugSaleDAO;
    }

    @Transactional
    public void addDrugSaleReceipt(DrugSaleReceipt drugSaleReceipt) {
        drugSaleReceiptDAO.addDrugSaleReceipt(drugSaleReceipt);
    }

    @Transactional
    public DrugSaleReceipt getDrugSaleReceipt(int  drugSaleReceiptNumber) {
        //return drugSaleReceiptDAO.
        return null;
    }

    @Transactional(readOnly = true)
    public List<DrugSaleRequest> getDrugSalesBetweenTwoDates(Timestamp fromDate, Timestamp toDate){
        //return drug_name + quantity + amount
        //later use this info to calculate total on FrontEnd
        return drugSaleDAO.getDrugSalesBetweenTwoDates(fromDate,toDate);
    }
}
