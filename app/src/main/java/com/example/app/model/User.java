package com.example.app.model;

import lombok.Data;

import javax.management.relation.Role;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String tenantId;
    private UserRole role;
    private String status;
}
