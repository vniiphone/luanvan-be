package com.luanvan.b1910025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diemDen")
public class DiemDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name khong duoc trong")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Dia Chi khong duoc trong")
    @Column(name = "diaChi", nullable = false)
    private String diaChi;

    @NotBlank(message = "Noi dung khong duoc trong")
    @Column(name = "noiDung", nullable = false)
    private String noiDung;

    @JoinColumn(name = "lichTrinhTour_Id")
    @ManyToOne
    private LichTrinhTour lichTrinhTour;

    public LichTrinhTour getLichTrinhTour() {
        return lichTrinhTour;
    }

    public void setLichTrinhTour(LichTrinhTour lichTrinhTour) {
        this.lichTrinhTour = lichTrinhTour;
    }

    public DiemDen(String name, String diaChi, String noiDung, LichTrinhTour lichTrinhTour) {
        this.name = name;
        this.diaChi = diaChi;
        this.noiDung = noiDung;
        this.lichTrinhTour = lichTrinhTour;
    }

    public DiemDen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public DiemDen(Long id, String name, String diaChi, String noiDung) {
        super();
        this.id = id;
        this.name = name;
        this.diaChi = diaChi;
        this.noiDung = noiDung;
    }
}
