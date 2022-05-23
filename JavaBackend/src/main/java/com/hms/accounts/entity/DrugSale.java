package com.hms.accounts.entity;

import javax.persistence.*;

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
    @Column(name="drug_name")
    private String drugName;
    @ManyToOne(fetch=FetchType.LAZY)
    private DrugSaleReceipt drugSaleReceipts;
    @Column(name="drug_cost")
    private double drugPrice;
    @Column(name="drug_quantity")
    private int drugQuantity;

    //we can generate total on the fly no need to store
}
