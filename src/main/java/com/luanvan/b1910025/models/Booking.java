package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer soLuongVeDat;
    //Thanh Toán: 1 - Chưa thanh toán: 0 - Chờ xác nhận: 2
    private int statusDat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;
    @JsonIgnore
    @JoinColumn(name = "hoaDon_id")
    @ManyToOne
    private HoaDon hoaDon;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "booking", orphanRemoval = true)
    private List<HanhKhach> hanhKhachs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSoLuongVeDat() {
        return soLuongVeDat;
    }

    public void setSoLuongVeDat(Integer soLuongVeDat) {
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

    public List<HanhKhach> getHanhKhachs() {
        return hanhKhachs;
    }

    public void setHanhKhachs(List<HanhKhach> hanhKhachs) {
        this.hanhKhachs = hanhKhachs;
    }


    public Booking() {
        super();
    }

    public Booking(User user, Tour tour, Integer soLuongVeDat) {
        super();
        this.soLuongVeDat = soLuongVeDat;
        this.user = user;
        this.tour = tour;
    }
}
