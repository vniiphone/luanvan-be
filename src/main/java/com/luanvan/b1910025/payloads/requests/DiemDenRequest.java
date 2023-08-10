package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;

public class DiemDenRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String diaChi;

    @NotBlank
    private String noiDung;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
