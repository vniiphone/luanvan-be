package com.luanvan.b1910025.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diaChi")
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Dia chi khong duoc trong")
    private String diaChi;

    @NotBlank(message = "SDT khong duoc trong")
    private String phone;

    @JoinColumn(name = "ward_id")
    @ManyToOne
    private Ward ward;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diaChi", orphanRemoval = true)
    private List<HoaDon> hoaDonList = new ArrayList<>();

    public String getDiachi() {
        return diaChi;
    }

    public void setDiachi(String diachi) {
        this.diaChi = diachi;
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

    public List<HoaDon> getHoaDonList() {
        return hoaDonList;
    }

    public void setHoaDonList(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    public DiaChi(Long id, String diaChi, String phone, Ward ward, User user, List<HoaDon> hoaDonList) {
        this.id = id;
        this.diaChi = diaChi;
        this.phone = phone;
        this.ward = ward;
        this.user = user;
        this.hoaDonList = hoaDonList;
    }

    public DiaChi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
