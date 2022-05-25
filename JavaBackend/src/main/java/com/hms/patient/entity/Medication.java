package com.hms.patient.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name="medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "drugs")
    private String drugs;

    //example: x-ray scan
    @Column(name = "treatment")
    private String treatment;

    @Column(name = "date_diagnosed")
    private final Timestamp dateDiagnosed = Timestamp.from(Instant.now());

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @Column(name = "amount_charged")
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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTreatmentAmount(double treatmentAmount) {
        this.treatmentAmount = treatmentAmount;
    }

    //In a one to many relationship, we override equals and hashcode methods on this side (@ManyToOne)

    //we override equals and hashcode  when we want to check for equality when removing an Object of this class.
    //We aren't deleting medical history for patient so no need of overriding equals and hashcode

}