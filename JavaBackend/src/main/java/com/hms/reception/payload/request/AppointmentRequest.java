package com.hms.reception.payload.request;

import java.sql.Timestamp;

public class AppointmentRequest {
    private final int DoctorId;
    private final int PatientId;
    private final Timestamp appointmentTime;


    public AppointmentRequest(int doctorId, int patientId, Timestamp appointmentTime) {
        DoctorId = doctorId;
        PatientId = patientId;
        this.appointmentTime = appointmentTime;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public int getPatientId() {
        return PatientId;
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }
}
