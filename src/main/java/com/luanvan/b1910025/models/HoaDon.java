package com.luanvan.b1910025.models;


import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ngayGioTao;

    @NotNull
    @Min(0)
    private double totalPrice;

    @JoinColumn(name = "user_id")
    @ManyToOne()
    private User user;

    @NotNull
    private boolean wasPay;

    @NotNull
    private String paymentMethod;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon", orphanRemoval = true)
    private List<Booking> bookingList = new ArrayList<>();

    @JoinColumn(name = "diaChi_id")
    @OneToOne
    private DiaChi diaChi;

    public HoaDon( String ngayGioTao,
                  double totalPrice, User user,
                  boolean wasPay, String paymentMethod,
                  List<Booking> bookingList, DiaChi diaChi) {
        super();

        this.ngayGioTao = ngayGioTao;
        this.totalPrice = totalPrice;
        this.user = user;
        this.wasPay = wasPay;
        this.paymentMethod = paymentMethod;
        this.bookingList = bookingList;
        this.diaChi = diaChi;
    }

    public String getNgayGioTao() {
        return ngayGioTao;
    }

    public void setNgayGioTao(String ngayGioTao) {
        this.ngayGioTao = ngayGioTao;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public HoaDon() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
