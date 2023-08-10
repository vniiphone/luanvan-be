package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lichTrinhTour")
public class LichTrinhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Size(min = 1, message = "Phải có lịch trình chi tiết từng ngày")
    private String lichTrinhChiTiet;

    @JoinColumn(name = "khachSan_id")
    @ManyToOne
    private KhachSan khachSan;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lichTrinhTour", orphanRemoval = true)
    private List<DiemDen> diemDen = new ArrayList<>();

    @NotBlank(message = "Phương tiện di chuyển trống")
    private String phuongTien;

    @NotBlank(message = "Số thứ tự ngày của lịch trình")
    private int sttLichTrinh;

    @NotBlank(message = "Tên lịch trình: ngày thứ ...")
    private String tenLichTrinh;

    @NotBlank(message = "Ghi chú lịch trình trống")
    private String ghiChu;


    private Boolean visible = Boolean.TRUE;


    public LichTrinhTour() {
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

    public KhachSan getKhachSan() {
        return khachSan;
    }

    public void setKhachSan(KhachSan khachSan) {
        this.khachSan = khachSan;
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


    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }




    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
