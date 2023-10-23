package com.luanvan.b1910025.payloads.responses;

public class TokenResponse {
    private boolean valid;

    public TokenResponse() {
        // Constructor mặc định, cần thiết cho Spring Boot
    }

    public TokenResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
