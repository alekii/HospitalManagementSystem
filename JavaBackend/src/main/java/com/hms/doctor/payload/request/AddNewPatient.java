package com.hms.doctor.payload.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AddNewPatient {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String doctorUsername;
}
