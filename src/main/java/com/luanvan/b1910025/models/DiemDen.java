package com.luanvan.b1910025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class DiemDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String diaChi;
    private String noiDung;

    private int giaVeThamQuan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lich_trinh_tour_id")
    private LichTrinhTour lichTrinhTour;


    public DiemDen() {
        super();
    }

    public DiemDen(String name, String diaChi, String noiDung,int giaVeThamQuan, LichTrinhTour lichTrinhTour) {
        super();
        this.name = name;
        this.diaChi = diaChi;
        this.noiDung = noiDung;
        this.giaVeThamQuan = giaVeThamQuan;
        this.lichTrinhTour = lichTrinhTour;
    }
}
