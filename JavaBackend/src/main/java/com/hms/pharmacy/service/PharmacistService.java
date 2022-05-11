package com.hms.pharmacy.service;

import com.hms.pharmacy.dao.PharmacistDAO;
import com.hms.pharmacy.entity.Pharmacist;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PharmacistService {
    private final PharmacistDAO pharmacistDAO;

    public PharmacistService(PharmacistDAO pharmacistDAO) {
        this.pharmacistDAO = pharmacistDAO;
    }

    @Transactional
    public void addPharmacist(Pharmacist pharmacist){
        pharmacistDAO.addPharmacist(pharmacist);
    }
    @Transactional
    public List<Pharmacist> findAll(){
        return pharmacistDAO.findAll();
    }

    @Transactional
    public Pharmacist findPharmacistById(int pharmacistId){
        return pharmacistDAO.findById(pharmacistId);
    }

    @Transactional
    public void updatePharmacist(Pharmacist pharmacist){
        pharmacistDAO.updatePharmacist(pharmacist);
    }

    @Transactional
    public void deletePharmacist(int pharmacistId){
        pharmacistDAO.deletePharmacist(pharmacistId);
    }
}
