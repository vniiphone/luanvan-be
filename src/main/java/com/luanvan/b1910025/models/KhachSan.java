package com.luanvan.b1910025.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "khachSan")
public class KhachSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Phải có tên khách sạn")
    private String name;

    @NotBlank(message = "Phải có số điện thoại")
    private String phone;

    @NotBlank(message = "Phải có địa chỉ khách sạn: Số - Đường - Phường/Xã - Quận/Huyện - Tỉnh")
    private String diaChiKsan;

    @NotBlank(message = "Phải có giá phòng: giá cho phòng đôi")
    private Double giaPhong;

    public KhachSan() {
    }

    public KhachSan(Long id, String name, String phone, String diaChiKsan, Double giaPhong) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.diaChiKsan = diaChiKsan;
        this.giaPhong = giaPhong;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
