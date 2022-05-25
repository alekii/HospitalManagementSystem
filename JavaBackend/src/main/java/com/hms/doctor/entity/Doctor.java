package com.hms.doctor.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hms.auth.entity.UserData;
import com.hms.common.model.Employee;
import com.hms.common.model.Gender;
import com.hms.patient.entity.Patient;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="doctors")
public class Doctor extends Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
    @JsonIgnore
    @Column(name="date_registered")
    private Timestamp dateRegistered = Timestamp.from(Instant.now());

    @Column(name = "speciality")
    private String Speciality;

    @Column(name = "room")
    private String Room;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserData user;

    //avoid chain deletion
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
            @JoinTable(name="doctor_patients",
                    joinColumns = {@JoinColumn(name="doctor_id")},
                    inverseJoinColumns ={@JoinColumn(name="patient_id")})
    @JsonIgnore
    Set<Patient> patients = new LinkedHashSet<>();

    public Doctor(String firstName, String lastName, int age, String email, String speciality, Gender gender, String room){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.email=email;
        this.Speciality =speciality;
        this.gender=gender;
        this.Room=room;
    }

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

    //since we use hashSet & it's a @ManyToMany R/ship
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
