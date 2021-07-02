package com.example.finalexercice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppRole {
    @Id
    private String roleName;

    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    public AppRole() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
