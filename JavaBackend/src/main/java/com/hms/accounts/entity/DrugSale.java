package com.hms.accounts.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="drug_sales")
public class DrugSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="id")
    private int drugId;
    @Column(name="drug_cost")
    private double drugCost;
    @Column(name="drug_quantity")
    private int drugQuantity;
    @Column(name="date_sale_made")
    private final Timestamp dateMadeSale = Timestamp.from(Instant.now());

    //we can generate total on the fly no need to store
}
