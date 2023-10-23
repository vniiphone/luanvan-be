package com.luanvan.b1910025.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
//@Builder
//@AllArgsConstructor
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diaChi;
    private String phone;

    @JoinColumn(name = "ward_id")
    @ManyToOne
    private Ward ward;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diaChi", orphanRemoval = true)
    private List<HoaDon> invoices = new ArrayList<>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
/*

    public List<HoaDon> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<HoaDon> invoices) {
        this.invoices = invoices;
    }
*/

    public DiaChi() {

    }


    public DiaChi(String address, String phone, Ward ward, User user) {
        this.diaChi = address;
        this.phone = phone;
        this.ward = ward;
        this.user = user;
    }

}
