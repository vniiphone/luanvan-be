package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class KhachSanRequest {

//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String diaChiKsan;

    @NotNull
    private Double giaPhong;

    @NotNull(message="lichTrinhTour_id: null")
    private Long lichTrinhTour_id;

    public KhachSanRequest(String name, String phone, String diaChiKsan, Double giaPhong) {
        this.name = name;
        this.phone = phone;
        this.diaChiKsan = diaChiKsan;
        this.giaPhong = giaPhong;
    }

    public Long getLichTrinhTour_id() {
        return lichTrinhTour_id;
    }

    public void setLichTrinhTour_id(Long lichTrinhTour_id) {
        this.lichTrinhTour_id = lichTrinhTour_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiaChiKsan() {
        return diaChiKsan;
    }

    public void setDiaChiKsan(String diaChiKsan) {
        this.diaChiKsan = diaChiKsan;
    }

    public Double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(Double giaPhong) {
        this.giaPhong = giaPhong;
    }
}
