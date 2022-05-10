package com.hms.reception.dao;

import com.hms.reception.entity.Appointment;

public interface AppointmentDAO {

      void createAppointment(Appointment appointment);
      boolean appointmentExists(int doctorId, int patientId);
}
