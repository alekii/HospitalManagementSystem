package com.hms.accounts.dao;

import com.hms.accounts.entity.TreatmentRevenue;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class TreatmentRevenueDAO {
    private final EntityManager entityManager;

    public TreatmentRevenueDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveTreatmentRevenue(TreatmentRevenue treatmentRevenue){
          Session session = entityManager.unwrap(Session.class);
          session.save(treatmentRevenue);
      }

      //Find Treatment Revenue by timeStamp ->time_from to time_to
}
