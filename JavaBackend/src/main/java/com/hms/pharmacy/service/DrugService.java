package com.hms.pharmacy.service;

import com.hms.pharmacy.dao.DrugDAO;
import com.hms.pharmacy.entity.Drug;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DrugService {
    private final DrugDAO drugDAO;

    public DrugService(DrugDAO drugDAO) {
        this.drugDAO = drugDAO;
    }

    @Transactional
    public void addDrug(Drug drug){
        drugDAO.addDrug(drug);
    }

    @Transactional
    public List<Drug> findDrug(String drugName){
        return drugDAO.findDrug(drugName);
    }

    @Transactional
    public double sellDrug(int drugId, int drugQuantity){
        return drugDAO.sellDrug(drugId,drugQuantity);
    }
}
