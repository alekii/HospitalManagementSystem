package com.hms.accounts.entity;

import com.hms.patient.entity.Medication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="drugSaleReceipts")
public class DrugSaleReceipt {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long id;
    @OneToMany(mappedBy ="drugSaleReceipts",cascade= CascadeType.ALL,orphanRemoval = true )
    private Set<DrugSale> drugSaleSet = new LinkedHashSet<>();
    @Column(name="date_sale_made")
    private final Timestamp dateOfSale = Timestamp.from(Instant.now());

    public void addReceipt(DrugSale drugSale){
        drugSaleSet.add(drugSale);
        drugSale.setDrugSaleReceipts(this);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof DrugSaleReceipt)) return false;
        return Objects.equals(id, ((DrugSaleReceipt) obj).getId());
    }
}
