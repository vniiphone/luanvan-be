package com.luanvan.b1910025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //    @ElementCollection
    private String imageUrls;
    //@ElementCollection
    private String imagePublicIds;


    //    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loai_tour_id") // thông qua khóa ngoại loaiTour_id
    private LoaiTour loaiTour;

    // Thêm trường mã tour và getter/setter cho nó
    private String tourCode;

    // Hàm tạo mã tour dựa trên định dạng và lưu vào tourCode
    public void generateTourCode() {
        // Đây là một ví dụ đơn giản, bạn có thể thay đổi định dạng dựa trên yêu cầu của bạn
        String codeFormat = "TOUR-%d-%03d"; // Ví dụ: TOUR-2023-001
        String formattedCode = String.format(codeFormat, LocalDate.now().getYear(), id);
        tourCode = formattedCode;
    }

    @JsonIgnore    // MappedBy trỏ tới tên biến Tour ở trong Image.
    @OneToMany(mappedBy = "tour",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

    //Một tour sẽ có 1 hoặc nhiều lịch trình tour:
    // ví dụ lịch trình ngày 1, lịch trình ngày 2
    // Nếu tour bị xóa, thì lịch trình cũng sẽ bị xóa: orphanRemoval = true
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tour", orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<LichTrinhTour> lichTrinhTours = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private List<HoaDon> hoaDons = new ArrayList<>();
    @Lob
    private String tomTat;
    private String ngayGioXuatPhat;
    private String ngayVe;
    private String noiKhoiHanh;
    private Double giaThamKhao;
    private int soLuongVe;
    private Boolean visible = Boolean.TRUE;


    //Khi tạo tour, không cần có sẵn lịch trình, lịch trình có thể thêm sau
    public Tour() {
        super();
    }


    public Tour(String name,
                String imageUrls,
                String imagePublicIds,
                LoaiTour loaiTour,
                List<LichTrinhTour> lichTrinhTours,
                String tomTat,
                String ngayGioXuatPhat,
                String ngayVe,
                String noiKhoiHanh,
                Double giaThamKhao,
                int soLuongVe,
                String tourCode,
                Boolean visible) {
        this.name = name;
        this.imageUrls = imageUrls;
        this.imagePublicIds = imagePublicIds;
        this.loaiTour = loaiTour;
        this.lichTrinhTours = lichTrinhTours;
        this.tomTat = tomTat;
        this.ngayGioXuatPhat = ngayGioXuatPhat;
        this.ngayVe = ngayVe;
        this.noiKhoiHanh = noiKhoiHanh;
        this.giaThamKhao = giaThamKhao;
        this.soLuongVe = soLuongVe;
        this.tourCode = tourCode;
        this.visible = visible;
    }

  /*  public Tour(String name, List<String> imageUrls, List<String> imagePublicIds, LoaiTour loaiTour, String tomTat, String ngayGioXuatPhat, String ngayVe, String noiKhoiHanh, Double giaThamKhao, int soLuongVe, Boolean visible) {
        this.name = name;
        this.imageUrls = imageUrls;
        this.imagePublicIds = imagePublicIds;
        this.loaiTour = loaiTour;
        this.tomTat = tomTat;
        this.ngayGioXuatPhat = ngayGioXuatPhat;
        this.ngayVe = ngayVe;
        this.noiKhoiHanh = noiKhoiHanh;
        this.giaThamKhao = giaThamKhao;
        this.soLuongVe = soLuongVe;
        this.visible = visible;
    }*/

   /*public Tour(
            String name,
            List<String> imageUrls,
            LoaiTour loaiTour,
            String tomTat,
            String ngayGioXuatPhat,
            String ngayVe,
            String noiKhoiHanh,
            Double giaThamKhao,
            int soLuongVe) {
        this.name = name;
        this.imageUrls = imageUrls;
        this.loaiTour = loaiTour;
        this.tomTat = tomTat;
        this.ngayGioXuatPhat = ngayGioXuatPhat;
        this.ngayVe = ngayVe;
        this.noiKhoiHanh = noiKhoiHanh;
        this.giaThamKhao = giaThamKhao;
        this.soLuongVe = soLuongVe;
    }*/

//    @Override
//    public String toString() {
//        return "Tour{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", imageUrls=" + imageUrls +
//                ", loaiTour=" + loaiTour +
//                ", bookings=" + bookings +
//                ", lichTrinhTours=" + lichTrinhTours +
//                ", tomTat='" + tomTat + '\'' +
//                ", ngayGioXuatPhat='" + ngayGioXuatPhat + '\'' +
//                ", ngayVe='" + ngayVe + '\'' +
//                ", noiKhoiHanh='" + noiKhoiHanh + '\'' +
//                ", giaThamKhao=" + giaThamKhao +
//                ", soLuongVe=" + soLuongVe +
//                ", visible=" + visible +
//                '}';
//    }
}
