package com.example.finalexercice.dao;

import com.example.finalexercice.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    public AppRole findByRoleName(String roleName);
}
