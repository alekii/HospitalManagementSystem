package com.hms.auth.request;
import lombok .*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SignupRequest {
    private String username;
    private String password;
    private List<String> role;
}
