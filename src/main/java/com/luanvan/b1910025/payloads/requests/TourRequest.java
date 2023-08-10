package com.luanvan.b1910025.payloads.requests;

import co.elastic.clients.util.DateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class TourRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "LoaiTour is required")
    private Long loaiTour_id;

    private List<ImageRequest> imagesList;

    private List<LichTrinhTourRequest> lichTrinhTourList;

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

    private Boolean visible = TRUE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLoaiTourId() {
        return loaiTour_id;
    }

    public void setLoaiTourId(Long loaiTour_id) {
        this.loaiTour_id = loaiTour_id;
    }

    public List<ImageRequest> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<ImageRequest> imagesList) {
        this.imagesList = imagesList;
    }

    public List<LichTrinhTourRequest> getLichTrinhTourList() {
        return lichTrinhTourList;
    }

    public void setLichTrinhTourList(List<LichTrinhTourRequest> lichTrinhTourList) {
        this.lichTrinhTourList = lichTrinhTourList;
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

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
