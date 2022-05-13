package com.hms.utils.pdfgenerator.model;

public class PatientBill {
    private String firstName;
    private String lastName;
    private String serviceRendered;
    private double amountCharged;

    public PatientBill() {
    }

    public PatientBill(String firstName, String lastName, String serviceRendered, double amountCharged) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceRendered = serviceRendered;
        this.amountCharged = amountCharged;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServiceRendered() {
        return serviceRendered;
    }

    public void setServiceRendered(String serviceRendered) {
        this.serviceRendered = serviceRendered;
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }
}
