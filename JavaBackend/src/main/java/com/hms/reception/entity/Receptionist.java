package com.hms.reception.entity;

import com.hms.common.model.Employee;
import com.hms.common.model.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;

@Entity
@Table(name="receptionists")
public class Receptionist {

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
}
