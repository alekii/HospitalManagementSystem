package com.hms.reception.dao;

import com.hms.reception.entity.Appointment;

import java.util.List;

public interface AppointmentDAO {

      void createAppointment(Appointment appointment);
      boolean appointmentExists(String room, String patientName);
      List<Appointment> findAll();
}
