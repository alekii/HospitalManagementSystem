package com.hms.accounts.service;

import com.hms.accounts.dao.TreatmentRevenueDAO;
import com.hms.accounts.entity.TreatmentRevenue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
