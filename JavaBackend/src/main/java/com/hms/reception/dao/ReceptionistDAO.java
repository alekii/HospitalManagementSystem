package com.hms.reception.dao;

import com.hms.reception.entity.Receptionist;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReceptionistDAO {
    private final EntityManager entityManager;

    public ReceptionistDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Receptionist> findAll(){
        Session session = entityManager.unwrap(Session.class);
        Query<Receptionist> receptionistQuery = session.createQuery("from Receptionist",Receptionist.class);
        return receptionistQuery.getResultList();
    }

    public Receptionist findById(int receptionistId){
        Session session = entityManager.unwrap(Session.class);
        return session.get(Receptionist.class,receptionistId);
    }

    public void addReceptionist(Receptionist receptionist){
        Session session = entityManager.unwrap(Session.class);
        session.save(receptionist);
    }

    public void updateReceptionist(Receptionist receptionist){
        Session session = entityManager.unwrap(Session.class);
        receptionist.setEmployeeId(0);
        session.save(receptionist);
    }

    public void deleteReceptionist(int receptionistId){
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("delete from Receptionist where id=:theReceptionistId ");
        theQuery.setParameter("theReceptionistId", receptionistId);
        theQuery.executeUpdate();
    }
}
