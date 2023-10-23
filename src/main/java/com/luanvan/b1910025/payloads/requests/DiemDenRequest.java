package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DiemDenRequest {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    private String name;

    @NotBlank
    private String diaChi;

    @NotBlank
    private String noiDung;

    @NotNull
    private int giaVeThamQuan;

    public int getGiaVeThamQuan() {
        return giaVeThamQuan;
    }

    public void setGiaVeThamQuan(int giaVeThamQuan) {
        this.giaVeThamQuan = giaVeThamQuan;
    }

    @NotNull
    private Long lichTrinhTour_Id;

    public Long getLichTrinhTour_Id() {
        return lichTrinhTour_Id;
    }

    public void setLichTrinhTour_Id(Long lichTrinhTour_Id) {
        this.lichTrinhTour_Id = lichTrinhTour_Id;
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
}
