package com.hms.reception.service;

import com.hms.reception.entity.Appointment;

public interface AppointmentService {
     void createAppointment(Appointment appointment);
     boolean appointmentExists(int doctorId, int patientId);
}
