package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class LichTrinhTourRequest {

    @NotBlank(message = "Phương tiện is required")
    private String phuongTien;

    @NotNull(message = "Số thứ tự lịch trình is required")
    private int sttLichTrinh;

    @NotBlank(message = "Tên lịch trình is required")
    private String tenLichTrinh;

    private String ghiChu;

    @NotBlank(message = "Lịch trình chi tiết is required")
    private String lichTrinhChiTiet;

    @NotNull
    private Long tour_id;

    @NotNull(message = "Điểm Đến list is required")
    private List<DiemDenRequest> diemDenRequests = new ArrayList<>();

//    @NotNull(message = "Khách Sạn request is required")
    private KhachSanRequest khachSanRequest;

    @NotNull(message = "Visible request")
    private boolean visible;

    @NotNull(message = "Visible nameKhachSan")
    private String nameKhachSan;
    @NotNull(message = "Visible diaChiKhachSan")
    private String diaChiKhachSan;
    @NotNull(message = "Visible giaPhongKhachSan")
    private double giaPhongKhachSan;
    @NotNull(message = "Visible phoneKhachSan")
    private String phoneKhachSan;

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

    public String getLichTrinhChiTiet() {
        return lichTrinhChiTiet;
    }

    public void setLichTrinhChiTiet(String lichTrinhChiTiet) {
        this.lichTrinhChiTiet = lichTrinhChiTiet;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public List<DiemDenRequest> getDiemDenRequests() {
        return diemDenRequests;
    }

    public void setDiemDenRequests(List<DiemDenRequest> diemDenRequests) {
        this.diemDenRequests = diemDenRequests;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getNameKhachSan() {
        return nameKhachSan;
    }

    public void setNameKhachSan(String nameKhachSan) {
        this.nameKhachSan = nameKhachSan;
    }

    public String getDiaChiKhachSan() {
        return diaChiKhachSan;
    }

    public void setDiaChiKhachSan(String diaChiKhachSan) {
        this.diaChiKhachSan = diaChiKhachSan;
    }

    public double getGiaPhongKhachSan() {
        return giaPhongKhachSan;
    }

    public void setGiaPhongKhachSan(double giaPhongKhachSan) {
        this.giaPhongKhachSan = giaPhongKhachSan;
    }

    public String getPhoneKhachSan() {
        return phoneKhachSan;
    }

    public void setPhoneKhachSan(String phoneKhachSan) {
        this.phoneKhachSan = phoneKhachSan;
    }
}
