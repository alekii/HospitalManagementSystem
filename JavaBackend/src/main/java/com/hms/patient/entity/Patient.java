package com.hms.patient.entity;

import com.hms.doctor.entity.Doctor;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="Age")
    private int age;

    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Medication> medication = new LinkedHashSet<>();

    @Column(name="payment_status")
    private PaymentStatus paymentStatus;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMedication(Medication medic){
        medication.add(medic);
        medic.setPatient(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return  true;
        if(!(obj instanceof Patient)) return  false;
        return Objects.equals(id, ((Patient) obj).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
