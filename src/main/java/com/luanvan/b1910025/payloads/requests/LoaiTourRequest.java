package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;

public class LoaiTourRequest {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "noiDung is required")
    private String noiDung;

    public LoaiTourRequest(String name, String noiDung) {
        this.name = name;
        this.noiDung = noiDung;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
