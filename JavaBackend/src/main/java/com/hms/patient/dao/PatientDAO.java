package com.hms.patient.dao;


import com.hms.patient.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
}
