package com.hms.pharmacy.dao;

import com.hms.pharmacy.entity.Drug;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DrugDAO {
    private final EntityManager entityManager;

    public DrugDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addDrug(Drug drug){
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(drug);
    }
    public Drug findDrug(int drugId){
        Session session = entityManager.unwrap(Session.class);
        return session.get(Drug.class,drugId);

    }

    public double sellDrug(int drugId, int drugQuantity){
        Session session = entityManager.unwrap(Session.class);
         Drug drug = session.get(Drug.class,drugId);
         double drugCost = drug.getPrice() * drugQuantity;
         drug.setNumberInStock(drug.getNumberInStock()-drugQuantity);
         session.save(drug);
         return drugCost;
    }

}
