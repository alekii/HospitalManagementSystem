package com.hms.pharmacy.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="drugs")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="drug_name")
    private String drugName;
    @Column(name="number_in_stock")
    private int numberInStock;
    @Column(name="distributor")
    private Distributor distributor;
    @Column(name="price")
    private double price;
}
