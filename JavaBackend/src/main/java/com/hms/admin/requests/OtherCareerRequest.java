package com.hms.admin.requests;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class OtherCareerRequest {
    private  String userName;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String gender;
}
