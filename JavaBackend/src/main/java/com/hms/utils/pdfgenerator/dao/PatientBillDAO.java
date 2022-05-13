package com.hms.utils.pdfgenerator.dao;

import com.hms.patient.entity.Patient;

public interface PatientBillDAO {
    Patient getPatientWithPendingPayment(int patientID);
}
