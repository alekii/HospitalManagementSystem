package com.hms.patient.dao;

import com.hms.patient.entity.Medication;
import com.hms.patient.entity.Patient;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class PatientDAO {
    private final EntityManager entityManager;

    public PatientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Patient findPatient(int patientId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Patient.class,patientId);
    }

    public void addMedication(Medication medication) {
        Session session = entityManager.unwrap(Session.class);
        session.save(medication);
    }

    public void updatePatient(Patient patient){
        Session session = entityManager.unwrap(Session.class);
        patient.setId(0);
        session.save(patient);
    }
}
