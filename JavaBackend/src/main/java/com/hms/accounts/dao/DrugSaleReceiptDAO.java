package com.hms.accounts.dao;

import com.hms.accounts.entity.DrugSaleReceipt;
import com.hms.accounts.request.DrugSaleRequest;
import com.hms.accounts.entity.DrugSale;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DrugSaleReceiptDAO {
    private final EntityManager entityManager;

    public DrugSaleReceiptDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addDrugSaleReceipt(DrugSaleReceipt drugSaleReceipt){
        Session session = entityManager.unwrap(Session.class);
        session.save(drugSaleReceipt);
    }

    public DrugSaleReceipt getDrugSaleReceipt(int drugSaleReceiptNumber){
        Session session = entityManager.unwrap(Session.class);
        return session.get(DrugSaleReceipt.class,drugSaleReceiptNumber);
    }
}
