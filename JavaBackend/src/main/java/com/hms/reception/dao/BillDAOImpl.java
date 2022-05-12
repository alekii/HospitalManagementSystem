package com.hms.reception.dao;

import com.hms.patient.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BillDAOImpl implements BillDAO{

    private final EntityManager entityManager;

    public BillDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Patient getPatientWithPendingPayment(int patientID) {
        //find the patient
        Session currentSession = entityManager.unwrap(Session.class);
        //get pending payment status
        Query<Patient> patientQuery = currentSession.createQuery("from Patient where id=:theId and paymentStatus=:paymentStatus", Patient.class);
        patientQuery.setParameter("theId",patientID);
        patientQuery.setParameter("paymentStatus","PENDING");
        return patientQuery.getSingleResult();
    }
}
