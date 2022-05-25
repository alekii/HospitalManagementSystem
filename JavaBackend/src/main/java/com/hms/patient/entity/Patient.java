package com.hms.patient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hms.common.model.Gender;
import com.hms.doctor.entity.Doctor;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
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
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private Gender gender;

    @ManyToMany(mappedBy = "patients")
    @JsonIgnore
    private Set<Doctor> doctors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Medication> medication = new LinkedHashSet<>();

    @Column(name = "payment_status", columnDefinition = "int default '0'")
    private PaymentStatus paymentStatus;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMedication(Medication medic) {
        medication.add(medic);
        medic.setPatient(this);
    }

}
