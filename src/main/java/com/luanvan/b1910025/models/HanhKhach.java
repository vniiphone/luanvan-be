package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
public class HanhKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoTenHK;
    private String sdtHK;
    private int doTuoiHK;
    private String diaChiHK;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;

    public HanhKhach() {
        super();
    }

    public HanhKhach( String hoTenHK, String sdtHK, int doTuoiHK, String diaChiHK, Booking booking) {
        super();
        this.hoTenHK = hoTenHK;
        this.sdtHK = sdtHK;
        this.doTuoiHK = doTuoiHK;
        this.diaChiHK = diaChiHK;
        this.booking = booking;
    }

}
