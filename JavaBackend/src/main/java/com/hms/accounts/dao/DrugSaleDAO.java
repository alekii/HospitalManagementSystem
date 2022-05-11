package com.hms.accounts.dao;

import com.hms.accounts.entity.DrugSale;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class DrugSaleDAO {
    private final EntityManager entityManager;

    public DrugSaleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addDrugSale(DrugSale drugSale){
        Session session = entityManager.unwrap(Session.class);
        session.save(drugSale);
    }
    //fetch drug sales between a certain timestamp

}
