package com.luanvan.b1910025.payloads.requests;

import com.luanvan.b1910025.models.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProfileRequest {

    @NotBlank(message = "Name Required")
    private String name;

    @NotBlank(message = "lastName Required")
    private String lastName;

    @NotNull
    @Min(value = 0, message = "Quá Nhỏ Tuổi")
    private int age;

    @NotBlank(message = "phoneNumber Required")
    private String phoneNumber;

    @NotBlank(message = "soCCCD Required")
    private String soCCCD;

    @NotBlank(message = "diaChiNha Required")
    private String diaChiNha;

    @NotBlank(message = "phuongXa Required")
    private String phuongXa;

    @NotBlank(message = "huyenThi Required")
    private String huyenThi;
    @NotBlank(message = "tinhThanh Required")
    private String tinhThanh;

    @NotNull(message = "user_id Required")
    private Long user_id;

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

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /*    private String avatart_url;

    @NotBlank
    @Email
    private String email;

    private String fullName;

    public String getAvatart_url() {
        return avatart_url;
    }

    public void setAvatart_url(String avatart_url) {
        this.avatart_url = avatart_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }*/
}
