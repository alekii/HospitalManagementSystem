package com.hms.patient.PatientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PatientListDTO {
private String firstName;
private String lastName;
private int age;
private String Gender;
}
