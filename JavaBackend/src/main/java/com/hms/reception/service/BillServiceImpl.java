package com.hms.reception.service;

import com.hms.patient.entity.Patient;
import com.hms.reception.dao.BillDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillServiceImpl implements BillService{
    private final BillDAO billDAO;

    public BillServiceImpl(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    @Transactional
    public Patient getPatientWithPendingPayment(int patientId) {
        return billDAO.getPatientWithPendingPayment(patientId);
    }
}
