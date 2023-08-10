package com.luanvan.b1910025.models;


import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Phải có số lượng vé")
    @Min(value = 1, message = "Số lượng vé phải lớn hơn 0")
    @Max(value = 100, message = "Số lượng vé phải nhỏ hơn 10")
    @Column(name = "soLuongVeDat", nullable = false)
    private int soLuongVeDat;

    //Thanh Toán - Chưa thanh toán
    @Column(name = "statusDat", nullable = true)
    private int statusDat;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "tour_id")
    @ManyToOne
    private Tour tour;

    @JoinColumn(name = "invoice_id")
    @ManyToOne
    private HoaDon hoaDon;

    public Booking() {
    }

    public Booking(int soLuongVeDat,
                   User user,
                   Tour tour) {
        super();
        this.soLuongVeDat = soLuongVeDat;
        this.user = user;
        this.tour = tour;
    }

    public int getSoLuongVeDat() {
        return soLuongVeDat;
    }

    public void setSoLuongVeDat(int soLuongVeDat) {
        this.soLuongVeDat = soLuongVeDat;
    }

    public int getStatusDat() {
        return statusDat;
    }

    public void setStatusDat(int statusDat) {
        this.statusDat = statusDat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
