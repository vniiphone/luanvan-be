package com.luanvan.b1910025.payloads.requests;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class TourRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "LoaiTour id is required")
    private Long loaiTour_id;

//    @NotNull(message = "ImageUrls list is required")
//    private List<String> imageUrls = new ArrayList<>();
    @NotNull(message = "ImageUrls list is required")
    private String imageUrls ;


    //    @NotNull(message = "imagePublicIds list is required")
//    private List<String> imagePublicIds = new ArrayList<>();
@NotNull(message = "imagePublicId list is required")
   private String imagePublicIds ;
    @NotNull(message = "LichTrinhTour list is required")
    private List<LichTrinhTourRequest> lichTrinhTourList = new ArrayList<>();

    @NotBlank(message = "Tóm tắt is required")
    private String tomTat;

    @NotBlank(message = "Ngày xuất phát is required")
    private String ngayGioXuatPhat;

    @NotBlank(message = "Ngày về đến is required")
    private String ngayVe;

    @NotBlank(message = "Nơi khởi hành is required")
    private String noiKhoiHanh;

    @DecimalMin(value = "0.0", inclusive = false, message = "Giá tham khảo must be greater than 0")
    private Double giaThamKhao;

    @NotNull(message = "Số lượng vé is required")
    @Min(value = 0, message = "Số lượng vé must be greater than or equal to 0")
    @Max(value = 500, message = "Số lượng vé must be less than or equal to 500")
    private int soLuongVe;

    private Boolean visible = Boolean.TRUE;



    public List<LichTrinhTourRequest> getLichTrinhTourList() {
        return lichTrinhTourList;
    }

    public void setLichTrinhTourList(List<LichTrinhTourRequest> lichTrinhTourList) {
        this.lichTrinhTourList = lichTrinhTourList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLoaiTour_id() {
        return loaiTour_id;
    }

    public void setLoaiTour_id(Long loaiTour_id) {
        this.loaiTour_id = loaiTour_id;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getNgayGioXuatPhat() {
        return ngayGioXuatPhat;
    }

    public void setNgayGioXuatPhat(String ngayGioXuatPhat) {
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

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getImagePublicIds() {
        return imagePublicIds;
    }

    public void setImagePublicIds(String imagePublicIds) {
        this.imagePublicIds = imagePublicIds;
    }

/*

    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "LoaiTour is required")
    private Long loaiTour_id;
    private List<ImageRequest> imagesList;
    private List<LichTrinhTourRequest> lichTrinhTourList;
    @NotBlank(message = "Phải có tóm tắt chuyến đi")
    private String tomTat;
    @NotBlank(message = "Phải có ngày xuất phát")
    private String ngayGioXuatPhat;
    @NotBlank(message = "Phải có ngày về đến")
    private String ngayVe;
    @NotBlank(message = "Phải có nơi khởi hành")
    private String noiKhoiHanh;
    @NotBlank(message = "Phải có giá tham khảo")
    private Double giaThamKhao;
    @NotBlank(message = "Phải có số lượng vé")
    private int soLuongVe;
    private Boolean visible = TRUE;
*/

  /*  public TourRequest(
            @NotBlank(message = "Name is required") String name,
            @NotNull Long loaiTour_id,
            @NotBlank(message = "Image is required") List<ImageRequest> imagesList,
            @NotBlank(message = "Lich Trình is required") List<LichTrinhTourRequest> lichTrinhTourList,
            @NotBlank(message = "Description is required") String tomTat,
            @NotNull String ngayGioXuatPhat,
            @NotNull String ngayVe,
            @NotBlank(message = "noi khoi hanh is required") String noiKhoiHanh,
            @NotNull Double giaThamKhao,
            @NotNull @Min(0) @Max(500) int soLuongVe) {
        super();
        this.name = name;
        this.loaiTour_id = loaiTour_id;
        this.imagesList = imagesList;
        this.lichTrinhTourList = lichTrinhTourList;
        this.tomTat = tomTat;
        this.ngayGioXuatPhat = ngayGioXuatPhat;
        this.ngayVe = ngayVe;
        this.noiKhoiHanh = noiKhoiHanh;
        this.giaThamKhao = giaThamKhao;
        this.soLuongVe = soLuongVe;
    }*/
}
