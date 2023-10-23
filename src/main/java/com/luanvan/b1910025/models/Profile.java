package com.luanvan.b1910025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private int age;

    @NotNull
    private String phoneNumber;

    @NotBlank
    private String soCCCD;

    @NotBlank
    private String diaChiNha;

    @NotBlank
    private String phuongXa;

    @NotBlank
    private String huyenThi;
    @NotBlank
    private String tinhThanh;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Profile(
            String name,
            String lastName,
            int age,
            String phoneNumber,
            String soCCCD,
            String diaChiNha,
            String phuongXa,
            String huyenThi,
            String tinhThanh,
            User user) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.soCCCD = soCCCD;
        this.diaChiNha = diaChiNha;
        this.phuongXa = phuongXa;
        this.huyenThi = huyenThi;
        this.tinhThanh = tinhThanh;
        this.user = user;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getHuyenThi() {
        return huyenThi;
    }

    public void setHuyenThi(String huyenThi) {
        this.huyenThi = huyenThi;
    }

    public Profile() {
    }

 /*   public Profile(
            String name,
            String lastName,
            int age,
            String phoneNumber,
            String soCCCD,
            String diaChiNha,
            String quanHuyen,
            String tinhThanh,
            User user) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.soCCCD = soCCCD;
        this.diaChiNha = diaChiNha;
        this.quanHuyen = quanHuyen;
        this.tinhThanh = tinhThanh;
        this.user = user;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public String getDiaChiNha() {
        return diaChiNha;
    }

    public void setDiaChiNha(String diaChiNha) {
        this.diaChiNha = diaChiNha;
    }



    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
