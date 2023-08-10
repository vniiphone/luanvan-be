package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ProfileRequest {

    private String avatart_url;

    @NotBlank
    @Email
    private String email;

    private String fullName;

    public String getAvatart_url() {
        return avatart_url;
    }

    public void setAvatart_url(String avatart_url) {
        this.avatart_url = avatart_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
