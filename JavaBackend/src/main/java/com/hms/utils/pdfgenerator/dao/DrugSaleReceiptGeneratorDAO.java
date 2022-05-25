package com.hms.utils.pdfgenerator.dao;


import javax.persistence.EntityManager;

public class DrugSaleReceiptGeneratorDAO {

    private final EntityManager entityManager;

    public DrugSaleReceiptGeneratorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
