/*
package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

public class KhachSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String diaChiKsan;
    private Double giaPhong;

*/
/*    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lich_trinh_tour_id")
    private LichTrinhTour lichTrinhTour;*//*


    public KhachSan() {
        super();
    }

    public KhachSan(
            String name,
            String phone,
            String diaChiKsan,
            Double giaPhong,
            LichTrinhTour lichTrinhTour) {
        super();
        this.name = name;
        this.phone = phone;
        this.diaChiKsan = diaChiKsan;
        this.giaPhong = giaPhong;
//        this.lichTrinhTour = lichTrinhTour;
    }
}
*/
