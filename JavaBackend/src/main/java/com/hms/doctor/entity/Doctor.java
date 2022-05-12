package com.hms.doctor.entity;
import com.hms.common.model.Employee;
import com.hms.common.model.Gender;
import com.hms.patient.entity.Patient;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name="doctors")
public class Doctor extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Email
    @Column(name = "email")
    private String email;
    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private Gender gender;
    @Column(name="date_registered")
    private Date dateRegistered;

    @Column(name = "speciality")
    private String Speciality;

    //avoid chain deletion
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
            @JoinTable(name="doctor_patients",
                    joinColumns = {@JoinColumn(name="doctor_id")},
                    inverseJoinColumns ={@JoinColumn(name="patient_id")})
    Set<Patient> patients = new LinkedHashSet<>();

    public void addPatient(Patient patient) {
         patients.add(patient);
         patient.getDoctors().add(this);
    }

    public int getId() {
        return Id;
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
        return Objects.equals(this.Id, ((Doctor) obj).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
