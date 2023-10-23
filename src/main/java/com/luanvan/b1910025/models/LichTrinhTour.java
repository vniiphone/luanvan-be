package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class LichTrinhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String phuongTien;
    private int sttLichTrinh;
    private String tenLichTrinh;
    private String ghiChu;
    private Boolean visible = Boolean.TRUE;

    private String nameKhachSan;
    private String diaChiKhachSan;
    private double giaPhongKhachSan;
    private String phoneKhachSan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id") // thông qua khóa ngoại tourId
    private Tour tour;
//    @JsonIgnore
    @Size(min = 1, message = "Phải có lịch trình chi tiết từng ngày")
    private String lichTrinhChiTiet;
//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,
            mappedBy = "lichTrinhTour", orphanRemoval = true)
    private List<DiemDen> diemDen = new ArrayList<>();
/*    @OneToOne(mappedBy = "lichTrinhTour", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private KhachSan khachSan;*/

    public LichTrinhTour(
            String phuongTien,
            int sttLichTrinh,
            String tenLichTrinh,
            String ghiChu,
            String nameKhachSan,
            String diaChiKhachSan,
            double giaPhongKhachSan,
            String phoneKhachSan,
            Tour tour,
            String lichTrinhChiTiet,
            List<DiemDen> diemDen) {
        this.phuongTien = phuongTien;
        this.sttLichTrinh = sttLichTrinh;
        this.tenLichTrinh = tenLichTrinh;
        this.ghiChu = ghiChu;
        this.nameKhachSan = nameKhachSan;
        this.diaChiKhachSan = diaChiKhachSan;
        this.giaPhongKhachSan = giaPhongKhachSan;
        this.phoneKhachSan = phoneKhachSan;
        this.tour = tour;
        this.lichTrinhChiTiet = lichTrinhChiTiet;
        this.diemDen = diemDen;
    }

    /*    public LichTrinhTour(
            String phuongTien,
            int sttLichTrinh,
            String tenLichTrinh,
            String ghiChu,
            Tour tour,
            String lichTrinhChiTiet,
            List<DiemDen> diemDen,
            KhachSan khachSan) {
        this.phuongTien = phuongTien;
        this.sttLichTrinh = sttLichTrinh;
        this.tenLichTrinh = tenLichTrinh;
        this.ghiChu = ghiChu;
        this.tour = tour;
        this.lichTrinhChiTiet = lichTrinhChiTiet;
        this.diemDen = diemDen;
        this.khachSan = khachSan;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
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

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getLichTrinhChiTiet() {
        return lichTrinhChiTiet;
    }

    public void setLichTrinhChiTiet(String lichTrinhChiTiet) {
        this.lichTrinhChiTiet = lichTrinhChiTiet;
    }

    public List<DiemDen> getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(List<DiemDen> diemDen) {
        this.diemDen = diemDen;
    }

    public LichTrinhTour() {
        super();
    }


}
