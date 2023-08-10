package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;

public class HanhKhachRequest {

    @NotBlank(message = "Phải có tên hàn khách")
    private String hoTenHK;

    @NotBlank(message = "Phải có số điện thoại HK")
    private String sdtHK;

    @NotBlank(message = "Phải có độ tuổi HK")
    private int doTuoiHK;

    @NotBlank(message = "Phải có địa chỉ HK")
    private String diaChiHK;

    public String getHoTenHK() {
        return hoTenHK;
    }

    public void setHoTenHK(String hoTenHK) {
        this.hoTenHK = hoTenHK;
    }

    public String getSdtHK() {
        return sdtHK;
    }

    public void setSdtHK(String sdtHK) {
        this.sdtHK = sdtHK;
    }

    public int getDoTuoiHK() {
        return doTuoiHK;
    }

    public void setDoTuoiHK(int doTuoiHK) {
        this.doTuoiHK = doTuoiHK;
    }

    public String getDiaChiHK() {
        return diaChiHK;
    }

    public void setDiaChiHK(String diaChiHK) {
        this.diaChiHK = diaChiHK;
    }
}
