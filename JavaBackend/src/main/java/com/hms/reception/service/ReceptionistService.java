package com.hms.reception.service;

import com.hms.reception.dao.ReceptionistDAO;
import com.hms.reception.entity.Receptionist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceptionistService {
    private final ReceptionistDAO receptionistDAO;

    public ReceptionistService(ReceptionistDAO receptionistDAO) {
        this.receptionistDAO = receptionistDAO;
    }

    @Transactional
    public void addReceptionist(Receptionist receptionist) {
     receptionistDAO.addReceptionist(receptionist);
    }
    @Transactional
    public List<Receptionist> findAll(){
        return receptionistDAO.findAll();
    }

    @Transactional
    public Receptionist findReceptionistById(int receptionistId){
        return receptionistDAO.findById(receptionistId);
    }

    @Transactional
    public void updatePharmacist(Receptionist receptionist){
        receptionistDAO.updateReceptionist(receptionist);
    }

    @Transactional
    public void deletePharmacist(int receptionistId){
        receptionistDAO.deleteReceptionist(receptionistId);
    }
}
