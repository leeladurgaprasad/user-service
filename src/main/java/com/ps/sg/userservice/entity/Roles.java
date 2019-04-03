package com.ps.sg.userservice.entity;

public enum Roles {
    ADMIN("ADMIN"),USER("USER");

    private String role;
    Roles(String role) {
        this.role = role;
    }
}
