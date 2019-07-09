package com.oneightwo.auth_jwt.repository;

import com.oneightwo.auth_jwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
