package com.hms.reception.controller;

import com.hms.reception.entity.Appointment;
import com.hms.reception.payload.request.AppointmentRequest;
import com.hms.reception.service.AppointmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment/")
@PreAuthorize("hasAuthority('RECEPTIONIST')")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("new")
    public String createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
      Appointment appointment = new Appointment();
            appointment.setRoom(appointmentRequest.getRoom());
            appointment.setPatientName(appointmentRequest.getPatientName());
            appointmentService.createAppointment(appointment);
            return "Appointment made successfully";
    }

    @GetMapping("find/all")
   public List<Appointment> findAllAppointments(){
        return appointmentService.findAll();
    }
}
