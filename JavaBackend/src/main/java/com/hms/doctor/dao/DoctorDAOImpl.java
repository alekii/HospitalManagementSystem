package com.hms.doctor.dao;

import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

    private final EntityManager entityManager;

    public DoctorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //define field for entitymanager

    //set up constructor injection

    @Override
    public List<Doctor> findAll() {
        //Get the current hibernate session
        Session session = entityManager.unwrap(Session.class);
        //Create Query
        Query<Doctor> theQuery= session.createQuery("from Doctor ",Doctor.class);
        //execute query and get result list
        //return the results
        return theQuery.getResultList();
    }

    @Override
    public Doctor findById(int Id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Doctor.class,Id);
    }

    @Override
    public void save(Doctor doctor) {
        Session session = entityManager.unwrap(Session.class);
        //save doctor
        session.saveOrUpdate(doctor);
    }

    @Override
    public void delete(int Id) {
        Session session = entityManager.unwrap(Session.class);
        //delete doctor
        Query deleteQuery = session.createQuery("delete from Doctor where id=:doctorId");
        deleteQuery.setParameter("doctorId",Id);
        deleteQuery.executeUpdate();
    }

    @Override
    public void addMedication(Medication medication) {
        Session session = entityManager.unwrap(Session.class);
        session.save(medication);
    }

}
