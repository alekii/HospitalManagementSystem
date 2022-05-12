package com.hms.accounts.dao;

import com.hms.accounts.dto.DrugSaleDTO;
import com.hms.accounts.entity.DrugSale;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

@Repository
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
   public List<DrugSaleDTO> getDrugSalesBetweenTwoDates(Timestamp fromDate, Timestamp toDate){
       Session session = entityManager.unwrap(Session.class);
       return session.createNativeQuery("select new com/hms/accounts/dto/DrugSaleDTO(d.drugId,d.drugCost,d.drugQuantity) from DrugSale d where d.dateOfSale >:fromTimestamp and d.dateOfSale <: toTimestamp",DrugSaleDTO.class)
               .setParameter("fromTimestamp",fromDate).setParameter("toTimestamp",toDate)
               .getResultList();
   }
}
