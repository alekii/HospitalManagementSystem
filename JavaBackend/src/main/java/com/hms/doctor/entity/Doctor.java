package com.hms.doctor.entity;
import com.hms.common.model.Employee;
import com.hms.patient.entity.Patient;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="doctors")
public class Doctor extends Employee {
    @Column(name = "speciality")
    private String Speciality;

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

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
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
