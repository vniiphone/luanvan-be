package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.*;

public class LichTrinhTourRequest {

    @Size(min = 1, message = "Phải có lịch trình chi tiết từng ngày")
    private String lichTrinhChiTiet;

    @NotNull(message = "KhachSan is required")
    private Long khachSanId;

    @NotBlank(message = "Phương tiện di chuyển trống")
    private String phuongTien;

    @NotBlank(message = "Số thứ tự ngày của lịch trình")
    private int sttLichTrinh;

    @NotBlank(message = "Tên lịch trình: ngày thứ ...")
    private String tenLichTrinh;

    @NotBlank(message = "Ghi chú lịch trình trống")
    private String ghiChu;

    public String getLichTrinhChiTiet() {
        return lichTrinhChiTiet;
    }

    public void setLichTrinhChiTiet(String lichTrinhChiTiet) {
        this.lichTrinhChiTiet = lichTrinhChiTiet;
    }

    public Long getKhachSanId() {
        return khachSanId;
    }

    public void setKhachSanId(Long khachSanId) {
        this.khachSanId = khachSanId;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public int getSttLichTrinh() {
        return sttLichTrinh;
    }

    public void setSttLichTrinh(int sttLichTrinh) {
        this.sttLichTrinh = sttLichTrinh;
    }

    public String getTenLichTrinh() {
        return tenLichTrinh;
    }

    public void setTenLichTrinh(String tenLichTrinh) {
        this.tenLichTrinh = tenLichTrinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
