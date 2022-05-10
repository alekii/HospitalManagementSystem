package com.hms.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="medication")
public class Medication {
    private int doctorId;
    private int patientId;
    private String diagnosis;
    private List<String> drugs;
    private final Timestamp dateDiagnosed = Timestamp.from(Instant.now());

    public String getDiagnosis() {
        return diagnosis;
    }
    public List<String> getDrugs() {
        return drugs;
    }
    public Timestamp getDateDiagnosed() {
        return dateDiagnosed;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }
}
