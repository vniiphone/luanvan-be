package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hanhKhach")
public class HanhKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Phải có tên hàn khách")
    private String hoTenHK;

    @NotBlank(message = "Phải có số điện thoại HK")
    private String sdtHK;

    @NotBlank(message = "Phải có độ tuổi HK")
    private int doTuoiHK;

    @NotBlank(message = "Phải có địa chỉ HK")
    private String diaChiHK;

    @JsonIgnore
    @JoinColumn(name = "booking_id", nullable = false)
    @ManyToOne
    private Booking booking;

    public HanhKhach() {
    }

    public HanhKhach(Long id, String hoTenHK, String sdtHK, int doTuoiHK, String diaChiHK, Booking booking) {
        super();
        this.id = id;
        this.hoTenHK = hoTenHK;
        this.sdtHK = sdtHK;
        this.doTuoiHK = doTuoiHK;
        this.diaChiHK = diaChiHK;
        this.booking = booking;
    }

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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
