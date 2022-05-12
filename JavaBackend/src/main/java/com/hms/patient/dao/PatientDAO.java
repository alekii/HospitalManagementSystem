package com.hms.patient.dao;

import com.hms.patient.entity.Medication;
import com.hms.patient.entity.Patient;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;

@Repository
public class PatientDAO {
    private final EntityManager entityManager;

    public PatientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPatient(Patient patient) {
        Session session = entityManager.unwrap(Session.class);
        session.save(patient);
    }

    public Patient findPatient(int patientId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Patient.class,patientId);
    }

    public void addMedication(int patientId,Medication medication) {
        Session session = entityManager.unwrap(Session.class);
        Patient patient = findPatient(patientId);
        patient.addMedication(medication);
        session.save(patient);
    }

    public void updatePatient(Patient patient){
        Session session = entityManager.unwrap(Session.class);
        patient.setId(0);
        session.save(patient);
    }


}
