package com.hms.utils.pdfgenerator.service;

import com.hms.patient.entity.Patient;

public interface PatientBillService {
    Patient getPatientWithPendingPayment(int patientId);
}
