package com.luanvan.b1910025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;


    @JsonIgnore
    @JoinColumn(name = "loaiTour_id", nullable = false)
    @ManyToOne
    private LoaiTour loaiTour;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tour", orphanRemoval = true)
    private List<Image> imagesList;


    //Một tour sẽ có 1 hoặc nhiều lịch trình tour:
    // ví dụ lịch trình ngày 1, lịch trình ngày 2
    // Nếu tour bị xóa, thì lịch trình cũng sẽ bị xóa: orphanRemoval = true
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tour", orphanRemoval = true)
    private List<LichTrinhTour> lichTrinhTourList;

    @NotBlank(message = "Phải có tóm tắt chuyến đi")
    private String tomTat;

    @NotBlank(message = "Phải có ngày xuất phát")
    private DateTime ngayGioXuatPhat;

    @NotBlank(message = "Phải có ngày về đến")
    private String ngayVe;

    @NotBlank(message = "Phải có nơi khởi hành")
    private String noiKhoiHanh;

    @NotBlank(message = "Phải có giá tham khảo")
    private Double giaThamKhao;

    @NotBlank(message = "Phải có số lượng vé")
    private int soLuongVe;

    private Boolean visible = Boolean.TRUE;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    //Khi tạo tour, không cần có sẵn lịch trình, lịch trình có thể thêm sau


    public Tour(String name, LoaiTour loaiTour, List<Image> imagesList, String tomTat, DateTime ngayGioXuatPhat, String ngayVe, String noiKhoiHanh, Double giaThamKhao, int soLuongVe) {
        this.name = name;
        this.loaiTour = loaiTour;
        this.imagesList = imagesList;
        this.tomTat = tomTat;
        this.ngayGioXuatPhat = ngayGioXuatPhat;
        this.ngayVe = ngayVe;
        this.noiKhoiHanh = noiKhoiHanh;
        this.giaThamKhao = giaThamKhao;
        this.soLuongVe = soLuongVe;
    }

    public List<Image> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Image> imagesList) {
        this.imagesList = imagesList;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public DateTime getNgayGioXuatPhat() {
        return ngayGioXuatPhat;
    }

    public void setNgayGioXuatPhat(DateTime ngayGioXuatPhat) {
        this.ngayGioXuatPhat = ngayGioXuatPhat;
    }

    public String getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(String ngayVe) {
        this.ngayVe = ngayVe;
    }

    public String getNoiKhoiHanh() {
        return noiKhoiHanh;
    }

    public void setNoiKhoiHanh(String noiKhoiHanh) {
        this.noiKhoiHanh = noiKhoiHanh;
    }

    public Double getGiaThamKhao() {
        return giaThamKhao;
    }

    public void setGiaThamKhao(Double giaThamKhao) {
        this.giaThamKhao = giaThamKhao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoaiTour getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(LoaiTour loaiTour) {
        this.loaiTour = loaiTour;
    }


    public List<LichTrinhTour> getLichTrinhTourList() {
        return lichTrinhTourList;
    }

    public void setLichTrinhTourList(List<LichTrinhTour> lichTrinhTourList) {
        this.lichTrinhTourList = lichTrinhTourList;
    }

    public String getTomtat() {
        return tomTat;
    }

    public void setTomtat(String tomTat) {
        this.tomTat = tomTat;
    }

    public Tour() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
