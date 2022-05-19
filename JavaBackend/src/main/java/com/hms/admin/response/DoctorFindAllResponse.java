package com.hms.admin.response;
import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class DoctorFindAllResponse {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String email;
    private String speciality;
    private String room;
}
