package com.groceriesapi.repository;

import com.groceriesapi.dataAccess.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByUsername(String username);
}
