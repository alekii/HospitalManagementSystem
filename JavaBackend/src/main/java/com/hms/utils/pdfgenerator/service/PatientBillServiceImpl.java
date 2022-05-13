package com.hms.utils.pdfgenerator.service;

import com.hms.patient.entity.Patient;
import com.hms.utils.pdfgenerator.dao.PatientBillDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientBillServiceImpl implements PatientBillService {
    private final PatientBillDAO billDAO;

    public PatientBillServiceImpl(PatientBillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    @Transactional
    public Patient getPatientWithPendingPayment(int patientId) {
        return billDAO.getPatientWithPendingPayment(patientId);
    }
}
