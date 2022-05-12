package com.hms.reception.payload.request;

import java.sql.Timestamp;

public class AppointmentRequest {
    private final int DoctorId;
    private String patientName;
    private final Timestamp appointmentTime;


    public AppointmentRequest(int doctorId, String patientName,  Timestamp appointmentTime) {
        DoctorId = doctorId;
        patientName = patientName;
        this.appointmentTime = appointmentTime;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }
}
