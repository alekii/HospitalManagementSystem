package com.hms.patient.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="medication")
public class Medication {

    @Column(name ="diagnosis")
    private List<String> diagnosis;

    @Column(name ="drugs")
    private List<String> drugs;

    @Column(name ="date_diagnosed")
    private final Timestamp dateDiagnosed = Timestamp.from(Instant.now());

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @Column(name ="amount_charged")
    private double treatmentAmount;

    //getters
    public List<String> getDiagnosis() {
        return diagnosis;
    }
    public List<String> getDrugs() {
        return drugs;
    }
    public Timestamp getDateDiagnosed() {
        return dateDiagnosed;
    }

    public Patient getPatient() {
        return patient;
    }
}
