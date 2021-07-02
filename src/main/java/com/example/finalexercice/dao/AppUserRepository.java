package com.example.finalexercice.dao;

import com.example.finalexercice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    public AppUser findByUsername(String username);
}
