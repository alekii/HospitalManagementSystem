package com.hms.reception.service;

import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Patient;
import com.hms.reception.dao.AppointmentDAO;
import com.hms.reception.entity.Appointment;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    @Transactional
    public void createAppointment(Appointment appointment) {
        appointmentDAO.createAppointment(appointment);
    }

    @Override
    @Transactional
    public boolean appointmentExists(int doctorId, int patientId) {
        return appointmentDAO.appointmentExists(doctorId,patientId);
    }
}
