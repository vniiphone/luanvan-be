package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalPrice;
    private boolean wasPay;
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String timeCreate;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon", orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

    @JoinColumn(name = "tour_id")
    @ManyToOne
    private Tour tour;

    private long soLuongVeDaDat;

    public long getSoLuongVeDaDat() {
        return soLuongVeDaDat;
    }

    public void setSoLuongVeDaDat(long soLuongVeDaDat) {
        this.soLuongVeDaDat = soLuongVeDaDat;
    }

    /*
    @JsonIgnore
    @JoinColumn(name = "dia_chi_id")
    @ManyToOne
    private DiaChi diaChi;
*/

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @JoinColumn(name = "profile_id")
    @ManyToOne
    private Profile profile;

    public HoaDon() {

    }

    public Long getId() {
        return id;
    }

  /*  public HoaDon(
            User user,
            @NotNull String timeCreate,
            @NotNull String paymentMethod,
            @NotNull @Min(0) double totalPrice,
            @NotNull boolean wasPay,
            List<Booking> bookings,
            Profile profile) {
        this.totalPrice = totalPrice;
        this.wasPay = wasPay;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.timeCreate = timeCreate;
        this.profile = profile;
        this.bookings = bookings;
    }*/

    public HoaDon(
            User user,
            @NotNull   String paymentMethod,
            @NotNull   String timeCreate,
            double totalPrice,
            boolean wasPay,
            List<Booking> bookings,
            Tour tour,
            long soLuongVeDaDat,
            Profile profile) {
        this.totalPrice = totalPrice;
        this.wasPay = wasPay;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.timeCreate = timeCreate;
        this.bookings = bookings;
        this.tour = tour;
        this.soLuongVeDaDat = soLuongVeDaDat;
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isWasPay() {
        return wasPay;
    }

    public void setWasPay(boolean wasPay) {
        this.wasPay = wasPay;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


/*    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }*/
}
