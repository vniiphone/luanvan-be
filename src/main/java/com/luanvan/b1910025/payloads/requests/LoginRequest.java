package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message="Must have username")
    private String username;

    @NotBlank(message="Must have password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
