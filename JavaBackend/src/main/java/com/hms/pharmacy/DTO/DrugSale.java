package com.hms.pharmacy.DTO;

public class DrugSale {
    int drugId;
    int drugQuantity;

    public DrugSale(int drugId, int drugQuantity) {
        this.drugId = drugId;
        this.drugQuantity = drugQuantity;
    }

    public int getDrugId() {
        return drugId;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }
}
