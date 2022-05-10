package com.hms.reception.service;

import com.hms.patient.entity.Patient;
import com.hms.reception.dao.BillDAO;

public class BillServiceImpl implements BillService{
    private final BillDAO billDAO;

    public BillServiceImpl(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    public Patient getPatientWithPendingPayment(int patientId) {
        return billDAO.getPatientWithPendingPayment(patientId);
    }
}
