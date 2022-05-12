package com.hms.accounts.dto;

public class DrugSaleDTO {
    private double drugCost;
    private int drugQuantity;
    private int drugId;

    public DrugSaleDTO(double drugCost, int drugQuantity, int drugId) {
        this.drugCost = drugCost;
        this.drugQuantity = drugQuantity;
        this.drugId = drugId;
    }

    public double getDrugCost() {
        return drugCost;
    }

    public void setDrugCost(double drugCost) {
        this.drugCost = drugCost;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
}
