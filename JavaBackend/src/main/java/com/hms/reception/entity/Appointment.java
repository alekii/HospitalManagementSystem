package com.hms.reception.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name="doctor_id")
    private int doctorID;

    @Column(name="patient_id")
    private int patientID;

    @Column(name="appointment_time")
    private Timestamp appointmentTime;

    @Column(name="status", columnDefinition = "varchar(20) default 'PENDING'")
    private AppointmentStatus status;
}
