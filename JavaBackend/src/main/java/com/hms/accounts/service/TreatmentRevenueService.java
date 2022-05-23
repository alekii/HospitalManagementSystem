package com.hms.accounts.service;

import com.hms.accounts.dao.TreatmentRevenueDAO;
import com.hms.accounts.request.TreatmentRevenueRequest;
import com.hms.accounts.entity.TreatmentRevenue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TreatmentRevenueService {
    private final TreatmentRevenueDAO treatmentRevenueDAO;

    public TreatmentRevenueService(TreatmentRevenueDAO treatmentRevenueDAO) {
        this.treatmentRevenueDAO = treatmentRevenueDAO;
    }

    @Transactional
      public void saveTreatmentRevenue(TreatmentRevenue treatmentRevenue){
       treatmentRevenueDAO.saveTreatmentRevenue(treatmentRevenue);
      }

    @Transactional
    public List<TreatmentRevenueRequest> getTreatmentRevenueBetweenTwoDates(Timestamp fromDate, Timestamp toDate){
        //return drug_name + quantity + amount
        //later use this info to calculate total on FrontEnd
        return treatmentRevenueDAO.getTreatmentRevenueBetweenTwoDates(fromDate,toDate);
    }
}
