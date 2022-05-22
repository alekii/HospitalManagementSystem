package com.hms.reception.entity;

import com.hms.common.model.Employee;
import com.hms.common.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name="receptionists")
public class Receptionist {

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
    @Column(name="date_registered")
    private Timestamp dateRegistered = Timestamp.from(Instant.now());
}
