package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DiaChiRequest {

    @NotNull
    private Long ward_id;

    @NotNull
    private Long district_id;

    @NotNull
    private String diaChi;

    @NotBlank
    private String phone;

    public Long getWard_id() {
        return ward_id;
    }

    public void setWard_id(Long ward_id) {
        this.ward_id = ward_id;
    }

    public Long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Long district_id) {
        this.district_id = district_id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public DiaChiRequest(@NotNull Long ward_id, @NotNull Long district_id,
                         @NotBlank String diaChi,@NotBlank String phoneNumber) {
        this.ward_id = ward_id;
        this.district_id = district_id;
        this.diaChi = diaChi;
        this.phone = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }
}
