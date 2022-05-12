package com.hms.accounts.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="treatment_revenue")
public class TreatmentRevenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private int doctorID;
    private int patientId;
    private Timestamp paymentDate;
    private double treatmentAmount;



}
