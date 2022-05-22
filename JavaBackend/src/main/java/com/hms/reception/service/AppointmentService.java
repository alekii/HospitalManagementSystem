package com.hms.reception.service;

import com.hms.reception.entity.Appointment;

import java.util.List;

public interface AppointmentService {
     void createAppointment(Appointment appointment);
     List<Appointment> findAll();
}
