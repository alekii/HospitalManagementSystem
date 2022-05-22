package com.hms.reception.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="room")
   private String room;

    @Column(name="patient_name")
    private String patientName;

    @Column(name="appointment_time")
    private Timestamp appointmentTime = Timestamp.from((Instant.now()));

    @Column(name="status", columnDefinition = "int default 0")
    private AppointmentStatus status;
}
