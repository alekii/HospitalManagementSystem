package com.hms.reception.dao;

import com.hms.patient.entity.Patient;

public interface BillDAO {
    Patient getPatientWithPendingPayment(int patientID);
}
