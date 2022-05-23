package com.hms.accounts.request;

public class TreatmentRevenueRequest {
    private  int patientId;
    private double treatmentAmount;

    public TreatmentRevenueRequest(int patientId, double treatmentAmount) {
        this.patientId = patientId;
        this.treatmentAmount = treatmentAmount;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getTreatmentAmount() {
        return treatmentAmount;
    }

    public void setTreatmentAmount(double treatmentAmount) {
        this.treatmentAmount = treatmentAmount;
    }
}
