package com.oneightwo.auth_jwt.repository;

import com.oneightwo.auth_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
