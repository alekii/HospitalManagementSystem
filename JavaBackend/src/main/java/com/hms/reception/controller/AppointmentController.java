package com.hms.reception.controller;

import com.hms.reception.entity.Appointment;
import com.hms.reception.payload.request.AppointmentRequest;
import com.hms.reception.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment/")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("new")
    public String createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        boolean exists = appointmentService.appointmentExists(appointmentRequest.getDoctorId(), appointmentRequest.getPatientId());
        if (exists) {
            Appointment appointment = new Appointment();
            appointment.setDoctorID(appointmentRequest.getDoctorId());
            appointment.setPatientID(appointmentRequest.getDoctorId());
            appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
            appointmentService.createAppointment(appointment);
            return "Appointment made successfully";
        } else {
            return "Appointment Already exists";
        }
    }
}
