package com.hms.admin.requests;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class DoctorRequest {
private String firstName;
private String lastName;
private int age;
private String email;
private String speciality;
private String gender;
private String room;


}
