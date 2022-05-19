package com.hms.auth.repository;

import com.hms.auth.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData,Long> {
    Boolean existsByUsername(String username) ;
    Optional<UserData> findByUsername(String username);
}
