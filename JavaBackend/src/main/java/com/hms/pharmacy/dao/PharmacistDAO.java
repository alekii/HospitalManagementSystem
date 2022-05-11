package com.hms.pharmacy.dao;

import com.hms.pharmacy.entity.Pharmacist;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;

public class PharmacistDAO {
    private final EntityManager entityManager;

    public PharmacistDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Pharmacist> findAll(){
        Session session = entityManager.unwrap(Session.class);
        Query<Pharmacist> pharmacistQuery = session.createQuery("from Pharmacist",Pharmacist.class);
        return pharmacistQuery.getResultList();
    }

    public Pharmacist findById(int pharmacistId){
        Session session = entityManager.unwrap(Session.class);
        return session.get(Pharmacist.class,pharmacistId);
    }

    public void addPharmacist(Pharmacist pharmacist){
        Session session = entityManager.unwrap(Session.class);
        session.save(pharmacist);
    }

    public void updatePharmacist(Pharmacist pharmacist){
        Session session = entityManager.unwrap(Session.class);
        pharmacist.setId(0);
        session.save(pharmacist);
    }

    public void deletePharmacist(int pharmacistId){
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("delete from Pharmacist where id=:thePharmacistId ");
        theQuery.setParameter("thePharmacistId", pharmacistId);
        theQuery.executeUpdate();
    }
}

