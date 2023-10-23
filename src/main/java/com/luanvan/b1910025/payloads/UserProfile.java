package com.luanvan.b1910025.payloads;

public class UserProfile {
    private Long id;
    private String username;
    private String name;
    private String role;



    public UserProfile(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
