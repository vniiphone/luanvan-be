package com.luanvan.b1910025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loaiTour")
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "LoaiTour name is required")
    private String name;

    @NotBlank(message = "noi dung is required")
    private String noiDung;

    public LoaiTour(Long id,
                    @NotBlank(message = "require name loaitour") String name,
                    String noiDung,
                    List<Tour> tours) {
        super();
        this.id = id;
        this.name = name;
        this.noiDung = noiDung;
        this.tours = tours;
    }

    public String getNoidung() {
        return noiDung;
    }

    public void setNoidung(String noiDung) {
        this.noiDung = noiDung;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiTour", orphanRemoval = true)
    private List<Tour> tours = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public LoaiTour() {

    }


}
