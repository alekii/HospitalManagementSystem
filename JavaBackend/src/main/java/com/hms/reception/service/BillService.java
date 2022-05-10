package com.hms.reception.service;

import com.hms.patient.entity.Patient;

public interface BillService {
    Patient getPatientWithPendingPayment(int patientId);
}
