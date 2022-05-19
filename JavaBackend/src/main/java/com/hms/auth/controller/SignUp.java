package com.hms.auth.controller;
import com.hms.auth.entity.Role;
import com.hms.auth.entity.RoleEnum;
import com.hms.auth.entity.UserData;
import com.hms.auth.repository.RoleRepository;
import com.hms.auth.repository.UserRepository;
import com.hms.auth.request.SignupRequest;
import com.hms.auth.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/auth/")
public class SignUp {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        UserData user = new UserData(request.getUsername(), passwordEncoder.encode(request.getPassword()));

        List<String> rolefromRequest = request.getRole();
        Set<Role> roles = new LinkedHashSet<>() {
        };
        for(String role : rolefromRequest){
             switch(role){
                 case "admin":
                     if (userRepository.existsByUsername(request.getUsername())) {
                     return ResponseEntity.badRequest()
                             .body(new MessageResponse("username exists"));
                 }
                     Role adminRole = roleRepository.findByRolename(RoleEnum.ADMIN)
                             .orElseThrow(() -> new RuntimeException("error"));
                     roles.add(adminRole);
                     break;

                 case "doctor":
                     Role doctorRole = roleRepository.findByRolename(RoleEnum.DOCTOR)
                             .orElseThrow(() -> new RuntimeException("error"));
                     roles.add(doctorRole);
                     break;
                 case "pharmacist":
                     Role patientRole = roleRepository.findByRolename(RoleEnum.PHARMACIST)
                             .orElseThrow(() -> new RuntimeException("error"));
                     roles.add(patientRole);
             }
        }

        user.setRole(roles);
        userRepository.save(user);
        return ResponseEntity.ok().body(new MessageResponse("Sign Up Success"));
    }
}
