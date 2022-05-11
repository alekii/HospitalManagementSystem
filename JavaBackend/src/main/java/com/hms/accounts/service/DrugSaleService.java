package com.hms.accounts.service;

import com.hms.accounts.dao.DrugSaleDAO;
import com.hms.accounts.entity.DrugSale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DrugSaleService {
    private final DrugSaleDAO drugSaleDAO;

    public DrugSaleService(DrugSaleDAO drugSaleDAO) {
        this.drugSaleDAO = drugSaleDAO;
    }

    @Transactional
    public void addDrugSale(DrugSale drugSale) {
        drugSaleDAO.addDrugSale(drugSale);
    }

    @Transactional
    public List<DrugSale> getDrugSalesBetweenTwoDates(Timestamp fromDate, Timestamp toDate){
        //return drug_name + quantity + amount
        //later use this info to calculate total on FrontEnd
    }
}
