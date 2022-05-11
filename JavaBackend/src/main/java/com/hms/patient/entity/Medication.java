package com.hms.patient.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="medication")
public class Medication {

    @Column(name ="diagnosis")
    private String diagnosis;

    @Column(name ="drugs")
    private String drugs;

    //example: x-ray scan
    @Column(name ="treatment")
    private String treatment;

    @Column(name ="date_diagnosed")
    private final Timestamp dateDiagnosed = Timestamp.from(Instant.now());

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @Column(name ="amount_charged")
    private double treatmentAmount;

    //getters
    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDrugs() {
        return drugs;
    }
    public Timestamp getDateDiagnosed() {
        return dateDiagnosed;
    }

    public Patient getPatient() {
        return patient;
    }

    public double getTreatmentAmount() {
        return treatmentAmount;
    }
}