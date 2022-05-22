package com.hms.reception.dao;

import com.hms.reception.entity.Appointment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO{
    private final EntityManager entityManager;

    public AppointmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createAppointment(Appointment appointment) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(appointment);
    }

    @Override
    public boolean appointmentExists(String room, String patientName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Appointment> findAppointmentQuery = currentSession.createQuery("from Appointment where room=:theRoom and patientId=:thePatientName", Appointment.class);
        findAppointmentQuery.setParameter("theRoom",room);
        findAppointmentQuery.setParameter("thePatientName", patientName);
         List<Appointment> results = findAppointmentQuery.getResultList();
         if (results == null) return false;
         boolean exists = false;
          for(Appointment s :results){
              if (s.getStatus().name().equals("PENDING")) {
                  exists = true;
                  break;
              }
          }
         return exists;
    }

    @Override
    public List<Appointment> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Appointment> appointmentQuery = session.createQuery("from Appointment",Appointment.class);
       return appointmentQuery.getResultList();
    }
}
