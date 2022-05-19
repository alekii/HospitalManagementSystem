package com.hms.auth.repository;

import com.hms.auth.entity.Role;
import com.hms.auth.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRolename(RoleEnum name);
}
