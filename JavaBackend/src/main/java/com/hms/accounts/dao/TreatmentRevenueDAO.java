package com.hms.accounts.dao;

import com.hms.accounts.request.TreatmentRevenueRequest;
import com.hms.accounts.entity.TreatmentRevenue;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

@Repository
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
      public List<TreatmentRevenueRequest> getTreatmentRevenueBetweenTwoDates(Timestamp fromDate, Timestamp toDate){
          Session session = entityManager.unwrap(Session.class);
          return session.createNativeQuery("select new com/hms/accounts/dto/TreatmentRevenueDTO(t.patientId,t.treatmentAmount) from TreatmentRevenue t where t.paymentDate>:fromTimestamp and d.paymentDate <: toTimestamp", TreatmentRevenueRequest.class)
                  .setParameter("fromTimestamp",fromDate).setParameter("toTimestamp",toDate)
                  .getResultList();
      }
}
