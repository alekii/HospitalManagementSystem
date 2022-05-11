package com.hms.doctor.entity;
import com.hms.patient.entity.Patient;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Email
    @Column(name = "email")
    String email;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "speciality")
    String Speciality;

    //avoid chain deletion
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
            @JoinTable(name="doctor_patients",
                    joinColumns = {@JoinColumn(name="doctor_id")},
                    inverseJoinColumns ={@JoinColumn(name="patient_id")})
    Set<Patient> patients = new LinkedHashSet<>();

    public void addPatient(Patient patient) {
         patients.add(patient);
         patient.getDoctors().add(this);
    }

    //since we use hashSet
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (!(obj instanceof Doctor)) return false;
        return Objects.equals(id, ((Doctor) obj).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
